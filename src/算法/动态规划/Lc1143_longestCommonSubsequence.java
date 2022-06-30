package 算法.动态规划;

/**
 * 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 */
public class Lc1143_longestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        char[] ch1=text1.toCharArray();
        char[] ch2=text2.toCharArray();

        //定义一个dp数组
        int[][] dp =new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(ch1[i-1]==ch2[j-1]){
                    dp[i][j] =dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
