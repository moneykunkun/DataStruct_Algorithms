package 算法.动态规划;

import java.util.Scanner;

//最大公共字串的长度
//https://www.nowcoder.com/questionTerminal/98dc82c094e043ccb7e0570e5342dd1b?commentTags=Python
public class Nc_maxPubStr {

    //获取两个字符串的最大公共长度
    //状态方程：f(i,j) 表示第一个字符串以第 i个字符结尾和第二个字符串以 第 j 个字符结尾的最大公共长度
    public static int maxLen(String s1,String s2){
        final char[] arr1 = s1.toCharArray();
        final char[] arr2 = s2.toCharArray();
        int len1= arr1.length;
        int len2= arr2.length;
        int maxLength=0;        //记录两个字符串的最大公共长度
        int[][]  dp =new int[len1+1][len2+1];       //dp数组
        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                //如果arr1 第i个 字符和 arr2 第 j个字符相等
                if (arr1[i-1]==arr2[j-1]){          //i-1 和 j-1表示的索引
                    dp[i][j]=dp[i-1][j-1]+1;
                    //更新最大长度
                    if (maxLength <dp[i][j]){
                        maxLength=dp[i][j];
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()){
            String s1= in.nextLine();
            String s2= in.nextLine();
            System.out.println(maxLen(s1,s2));
        }
    }
}
