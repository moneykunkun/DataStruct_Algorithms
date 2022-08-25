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
        res[0] =1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] ==nums[i-1]+1){
                //连续的情况 长度在上一个基础上+1
                res[i] =res[i-1]+1;
            }else if (nums[i] ==nums[i-1]){
                //前后相等
                res[i] =res[i-1];
            }else {
                //否则，连续长度就为1
                res[i] =1;
            }
        }
        //对保存长度记录排序，返回最长的记录
        Arrays.sort(res);
        return res[res.length-1];
    }
}
