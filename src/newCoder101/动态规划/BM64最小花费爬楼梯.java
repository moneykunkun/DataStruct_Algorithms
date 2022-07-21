package newCoder101.动态规划;

public class BM64最小花费爬楼梯 {


    /**
     * 最小花费
     * @param cost
     * @return
     * dp[i]表示到达第i层做需要的花费
     * 状态转移方程：dp[i] =Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
     */
    public int minCostClimbingStairs (int[] cost) {
        int len =cost.length;
        //存储楼层花费的数组
        int[] dp =new int[len+1];
        for (int i = 2; i <dp.length ; i++) {
            //第i层花费等于前一层的花费和后一层的花费的最小值
            dp[i] =Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[len];
    }
}
