package leetcode;

import java.util.Arrays;

public class Num128_最长连续序列 {
    /**
     * 排序加记录
     * 实践空间复杂度O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length ==0 ){
            return 0;
        }
        //排序
        Arrays.sort(nums);
        //记录连续最长数组的长度
        int[] res =new int[nums.length];
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] ==nums[i-1]+1){
                //连续的情况 在上
                res[i] =res[i-1]+1;
            }
        }
    }
}
