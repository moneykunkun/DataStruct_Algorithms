package 算法.动态规划;

/**
 * 完全平方数和
 */
public class Num279_numSquares {
    public int numSquares(int n) {
    //定义dp数组
        int[] dp= new int[n+1];
        dp[0]=0;
        for (int i =1; i <=n ; i++) {
            dp[i]=i;
            for (int j =1; j*j <= i; j++) {
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
