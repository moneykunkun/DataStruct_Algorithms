package 剑指offer;

public class Offer47_礼物的最大价值 {

    public int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //dp数组
        int[][] dp =new int[m+1][n+1];
        dp[0][0]=grid[0][0];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]=grid[i-1][j-1]+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
