package 算法.动态规划;

//最长递增子序列
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
public class Lc300_lengthOfLIS {
    /**
     * 求数组中最长的上升子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp =new int[nums.length];
        dp[0]=1;
        int maxans=1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxans=Math.max(dp[i],maxans);
        }
        return maxans;
    }
}
