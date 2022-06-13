package 算法.other;


import java.util.HashMap;
import java.util.Map;

public class Num1_twosSum {

    /**
     * 给定一个数组，求数组中和为target的两个正数，返回其索引
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        int[] result =new int[2];
        for (int i = 0; i < nums.length; i++) {
            int anotherNum= target-nums[i];
            Integer anotherIndex=map.get(anotherNum);
            if (anotherIndex != null ){
                result[0] =anotherIndex;
                result[1] =i;
                break;
            }else {
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
