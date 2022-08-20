package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num136_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int res=-1;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue()==1){
                res = entry.getKey();
            }
        }
        return res;
    }
}
