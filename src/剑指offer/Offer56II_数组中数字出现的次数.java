package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class Offer56II_数组中数字出现的次数 {

    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
