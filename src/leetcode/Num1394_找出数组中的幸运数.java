package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num1394_找出数组中的幸运数 {

    public int findLucky(int[] arr) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int i : arr) {
                map.put(i, map.getOrDefault(i,0)+1);
        }
        int ans =-1;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key =entry.getKey(),value =entry.getValue();
            if (key ==value){
                ans=Math.max(ans,key);
            }
        }
        return ans;
    }
}
