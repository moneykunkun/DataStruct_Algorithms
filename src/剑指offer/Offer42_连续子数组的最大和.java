package 剑指offer;

public class Offer42_连续子数组的最大和 {
    /**
     *解法1 ：用一个变量保存数组和最大值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum =0;
        int ans =nums[0];
        //遍历数组，更新最大值
        for (int num : nums) {
            maxSum =Math.max(maxSum+num,num);
            ans=Math.max(ans,maxSum);
        }
    return ans;
    }

}
