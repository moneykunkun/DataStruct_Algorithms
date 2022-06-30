package 算法.动态规划;

import java.util.Scanner;

//求字典序在 s1 和 s2 之间的，长度在 len1 到 len2 的字符串的个数，结果 mod 1000007。
//链接：https://www.nowcoder.com/questionTerminal/f72adfe389b84da7a4986bde2a886ec3
//来源：牛客网
public class Nc_wordCount {
    /**
     * 解读:
     * 典序的意思：即从两个字符串的下标为0开始进行对比，字典序是从左往右进行对比的。
     * 例如ab，abc这样两者之间的字符串个数为aba、abb，而ab、bb两者之间的字符串个数为：ac、ad、ae…az、ba这26个，
     * 所以高位的字符串个数要是26的i次幂。
     * 其次，要理解题目的“长度在len1到len2的字符串的个数”，指的是长度在len1的字符串个数、长度在len1+1的字符串个数。。。
     * 长度为len2的字符串个数。
     * 例abcde、acede这两个字符串，长度为1到4表示的是长度为1的时候两个字符a、a之间的个数，长度为2的时候两个字符ab、ac之间的个数，长度为3的时候abc、ace两个字符串之间的个数，长度为4：abcd、aced的个数。
     * 所以计算的时候应该以长度作为变量遍历len1到len2之间的字符串个数，最后相加。
     */
    public  static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            String str1 =sc.next();
            String str2=sc.next();
            int len1=sc.nextInt();
            int len2=sc.nextInt();

            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            int count = 0;
            // 定义一个长度为len2+1的数组，用于保存每个长度下两个字符串之间的字符串数
            int[] dp = new int[len2 + 1];
            // 从长度为1开始循环到len2结束，这里dp数组是从下标为1开始存储对应长度的字符数
            for (int i = 1; i <= len2; i++) {
                // 每个长度下拥有的字符串个数为上一个长度下字符串个数乘以26（不是最终结果，后面还有加减操作）
                dp[i] = (dp[i - 1] * 26) % 1000007;
                // 如果长度没有超过str1，那么需要减去str1这一位置上的那个字符与96的差值
                // （该值表示在范围之外的个数，也就是*26那步操作多计算进去的几个）
                if (i <= str1.length()) {
                    dp[i] = dp[i] - (char1[i - 1] - 96);
                }
                // 如果长度没有超过str2，那么需要加上str2这一位置上的哪个字符与96的差值（该值表示还有几个是上述*26没有算上了）
                if (i <= str2.length()) {
                    dp[i] = dp[i] + (char2[i - 1] - 96);
                }
                if (i >= len1) {
                    count += dp[i];
                }
            }
            // 最后结束叠加时，需要-1，因为最后的长度下需要减去str2最后一个字符的自身情况
            System.out.println((count - 1) % 1000007);
        }
        sc.close();
    }
}
