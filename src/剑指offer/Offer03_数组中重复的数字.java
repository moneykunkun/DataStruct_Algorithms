package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Offer03_数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int res =-1;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>1){
             res =entry.getKey();
            }
        }
        return  res;
    }

    /**
     * set集合
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        int res =-1;
        HashSet<Integer> set =new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                res =num;
            }
        }
        return res;
    }

}
