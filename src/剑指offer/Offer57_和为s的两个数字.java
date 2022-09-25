package 剑指offer;

public class Offer57_和为s的两个数字 {

    public int[] twoSum(int[] nums, int target) {
        //双指针遍历
        int i=0,j= nums.length-1;
        while (i < j) {
            int sum =nums[i] + nums[j];
            if (sum >target ) {
                j--;
            }else if (sum < target){
                i++;
            }else {
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[0];
        }
    }
