package newCoder101.动态规划;

import java.util.Arrays;

public class BM79打家劫舍二 {

    /**
     * 带有环的数组，只能选择第一家或者最后一家
     * @param nums
     * @return
     */
    public int rob (int[] nums) {
        //dp[i] 表示长度为i的数组最多能偷多少钱
        int[] dp =new int[nums.length+1];
        //选择偷第一家
        dp[1] =nums[0];
        //最后一家不能偷
        for (int i = 2; i < nums.length ; i++) {
            dp[i]=Math.max(dp[i-1],nums[i-1]+dp[i-2] );
        }
        //保存一下
        int res =dp[nums.length-1];
        //清除数组，进行第二次循环
        Arrays.fill(dp,0);
        //不偷第一家
        dp[1] =0;
        for (int i = 2; i <= nums.length ; i++) {
                dp[i] =Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        }
        //选择偷第一家和不偷第一家的最大值
        return Math.max(res,dp[nums.length]);
    }


}
