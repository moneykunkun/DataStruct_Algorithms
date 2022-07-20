package newCoder101.排序;

public class BM19寻找峰值 {

    public int findPeakElement (int[] nums) {
        // write code here
        int left=0;
        int right=nums.length-1;

        while (left<right){
            //找到中间位置
            int mid =(left+right)/2;
            if (nums[mid]>nums[mid+1]){
                //向右是递减的，不一定有波峰，收缩右区间
                right=mid;
            }else {
                //向右是递增的，收缩左区间
                left =mid+1;
            }
        }
        return right;
    }
}
