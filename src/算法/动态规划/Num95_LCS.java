package 算法.动态规划;

/**
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class Num95_LCS {
    public int longestCommonSubsequence(String text1, String text2) {
    int m=text1.length();
    int n=text2.length();
    int[][] dp =new int[m+1][n+1];

    for (int i=1;i<=m;i++){
        char c1=text1.charAt(i-1);
        for (int j = 1; j <=n ; j++) {
            char c2=text2.charAt(j-1);
            if (c1==c2){
                dp[i][j]=dp[i-1][j-1]+1;
            }else {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    return dp[m][n];
    }
}
