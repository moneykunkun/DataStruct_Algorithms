package newCoder101.哈希;

import java.util.HashMap;

public class BM51数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map =new HashMap<>();
        //遍历原来的数组
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])){
                //map中不包含当前元素，就将该元素存入map，并记录元素的次数
                map.put(array[i],1);
            }else {
                //集合中已存在
                map.put(array[i],map.get(array[i])+1);
            }
            if (map.get(array[i]) >array.length/2){
                return map.get(array[i]);
            }
        }
        return 0;
    }
}
