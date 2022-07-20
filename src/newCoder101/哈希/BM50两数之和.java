package newCoder101.哈希;

import java.util.HashMap;
import java.util.Map;

public class BM50两数之和 {

    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> map =new HashMap<>();
        int[] result =new int[2];
        //遍历原数组
        for (int i = 0; i < numbers.length; i++) {
            int anotherNum =target-numbers[i];
            //另一个数的索引
            Integer anotherIndex =map.get(anotherNum);
            if (anotherIndex !=null){
                result[0] =anotherIndex+1;
                result[1] =i+1;
                break;
            }else {
                map.put(numbers[i],i);
            }

        }

        return  result;
    }
}
