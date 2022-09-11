package 技术笔试;

public class Lc53_最大子数组和 {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp =new int[nums.length];
        //数组只有一个元素时，最大值就是nums[0]
        dp[0] =nums[0];
        //标记一个最大值
        int max=dp[0];
        for (int i = 1; i < nums.length ; i++) {
            dp[i] =Math.max(dp[i-1]+nums[i],nums[i] );
            if (dp[i]>max){
                //更新max
                max=dp[i];
            }
        }
        return max;
    }
    }
