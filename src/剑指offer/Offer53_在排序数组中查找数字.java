package 剑指offer;

import java.util.HashMap;

public class Offer53_在排序数组中查找数字 {

    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if (map.containsKey(target)){
            return map.get(target);
        }
        return 0;
    }
}
