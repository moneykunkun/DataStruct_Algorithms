package 算法.动态规划;

/**
 * 最大连续 子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Num53_maxSubArray {
    public int maxSubArray(int[] nums) {
    int len =nums.length;
    int[] dp =new int[len];
    dp[0]=nums[0];
    int max=dp[0];
    for (int i=1;i<len;i++){
        //状态方程
        dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        if (dp[i]>max){
            max=dp[i];
        }
    }
    return max;
    }
}
