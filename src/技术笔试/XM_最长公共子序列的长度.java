package 技术笔试;

public class XM_最长公共子序列的长度 {

    public static int longestCommonStr(String s1,String s2) {
        int m =s1.length();
        int n =s2.length();
        int[][]  dp =new int[m+1][n+1];

        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=m ; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] =dp[i-1][j]-1+1;
                }else {
                    dp[i][j] =Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
return dp[m][n];
    }
}
