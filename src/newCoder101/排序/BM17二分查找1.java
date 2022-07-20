package newCoder101.排序;

public class BM17二分查找1 {
    public int search (int[] nums, int target) {
        int left=0;
        int right= nums.length-1;
        //目标值所在的索引位置
        while (left<=right){
            int mid=(right+left)/2;
            if(nums[mid] ==target){
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right =mid-1;
            }
        }
        return -1;
    }
}
