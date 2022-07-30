package newCoder101.动态规划;

public class BM78打家劫舍一 {

    /**
     * 你不能偷相邻的两家，即，如果偷了第一家，就不能再偷第二家；如果偷了第二家，那么就不能偷第一家和第三家。
     * @param nums
     * @return
     */
    public int rob (int[] nums) {
        int n =nums.length;
        if (n<=1) return n==0?0:nums[0];
        //保存能偷到的最大金额
        int[] dp =new int[n];
        dp[0] =nums[0];
        dp[1] =Math.max(nums[0],nums[1]);

        for (int i = 2; i <n ; i++) {
            //状态转移方程，小偷不能偷相邻的
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}
