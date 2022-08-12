package newCoder101.双指针;

import java.util.HashMap;
import java.util.Map;

public class BM92最长无重复子数组 {

    public int maxLength (int[] arr) {
        // write code here
        if (arr.length ==0){
            return 0;
        }
        Map<Integer,Integer> map =new HashMap<>();
        int max =0;
        for (int i = 0,j=0; i <arr.length ; i++) {
            if (map.containsKey(arr[i])){
                 j =Math.max(map.get(arr[i])+1,j);
            }
            map.put(arr[i],i);
            max =Math.max(max,i-j+1);
        }
        return max;
    }
}
