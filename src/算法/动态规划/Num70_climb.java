package 算法.动态规划;

public class Num70_climb {
    //动态规划 类似于斐波那契数列
    public int climbStairs(int n) {
        //状态转移方程
        //dp[n]=dp[n-1]+dp[n-2];
    int[] dp =new int[46];
    //初始化
        dp[0] =0;
        dp[1] =1;
        for (int i = 2; i <dp.length ; i++) {
            dp[i] =dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
