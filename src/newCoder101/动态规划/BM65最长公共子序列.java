package newCoder101.动态规划;

public class BM65最长公共子序列 {

    public String LCS (String s1, String s2) {
        // write code here
        int n1=s1.length();
        int n2=s2.length();
        //表示当处理到s1的第i个元素和s2的第j个元素时公共子序列的长度
        String[][] dp =new String[n1+1][n2+1];
        for (int i = 0; i <=n1 ; i++) {
            for (int j = 0; j <=n2 ; j++) {
                if (i==0 || j==0){
                    dp[i][j]="";
                }else if (s1.charAt(i-1) ==s2.charAt(j-1)){
                    //dp[i][j] =dp[i-1][j-1]+1;
                    dp[i][j] =dp[i-1][j-1]+s1.charAt(i-1);
                }else{
                    //dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])
                    dp[i][j]=dp[i-1][j].length() >dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        if (dp[n1][n2] =="") {
            return "-1";
        }
        return dp[n1][n2];
    }
}
