package newCoder101.动态规划;

public class BM68矩阵的最小路径和 {


    public int minPathSum (int[][] matrix) {
        // write code here
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp =new int[n+1][m+1];
        dp[0][0] =matrix[0][0];
        //处理第一列
        for (int i = 1; i < n; i++) {
            dp[i][0] =dp[i-1][0]+matrix[i][0];
        }
        //处理第一列
        for (int j = 1; j < m; j++) {
            dp[0][j] =dp[0][j-1]+matrix[0][j];
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] =matrix[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }


}
