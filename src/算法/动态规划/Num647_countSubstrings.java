package 算法.动态规划;


public class Num647_countSubstrings {
    /**
     * 回文子串
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/palindromic-substrings
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len =s.length();
        boolean[][] dp =new boolean[len][len];
        int count =0;
        //字符串从后往前判断
        for (int i = dp.length-1; i >=0; i--) {
            for (int j = i; j < dp.length; j++) {
                //如果i和j指向的字符串不一样，那么dp[i][j]就不能构成回文串
                if(s.charAt(i) != s.charAt(j)){
                    continue;
                }
                dp[i][j] =j-i<=2 || dp[i+1][j-1];
                //如果从i到j能构成回文串，count+1
                if (dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}
