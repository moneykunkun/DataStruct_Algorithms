package 算法.动态规划;

//爬楼梯
public class Lc70_climbStairs {
    public int climbStairs(int n) {
        int[] dp =new int[46];
        dp[0]=1;
        dp[1] =1;
        for (int i = 2; i <dp.length ; i++) {
            dp[i] =dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
