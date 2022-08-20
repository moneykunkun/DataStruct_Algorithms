package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num169_多数元素 {

    public int majorityElement(int[] nums) {
        int n =nums.length;
        Map<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int res=-1;
        for (Map.Entry<Integer,Integer>  entry : map.entrySet()){
            if (entry.getValue() >(n>>=1)){
                res =entry.getKey();
            }
        }
        return res;
    }
}
