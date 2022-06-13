package 算法.other;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 时间复杂度要求：O（log^n）
 */
public class Lc35_insertLocation {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int ans=0;
        while (left<right){
            int mid=left+(right-left)>>1;
            if (target<mid){
                ans=mid;
                right=mid+1;
            }else {
                left=mid-1;
            }
        }
        return ans;
    }
}
