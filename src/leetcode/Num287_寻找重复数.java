package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num287_寻找重复数 {

    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map =new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int num =-1;
        for (Map.Entry<Integer,Integer> entry:map.entrySet() ){
            if (entry.getValue()>1){
                 num =entry.getKey();
            }
        }
        return num;
    }
}
