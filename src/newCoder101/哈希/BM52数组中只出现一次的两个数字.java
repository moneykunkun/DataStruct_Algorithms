package newCoder101.哈希;

import java.util.*;


public class BM52数组中只出现一次的两个数字 {

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        //存储数组中元素出现的次数
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        //再次遍历数组
        for (int j = 0; j < array.length; j++) {
            if (map.get(array[j]) == 1) {
                list.add(array[j]);
            }
            //整理一下次序

        }
        if (list.get(0) > list.get(1)) {
            return new int[]{list.get(1), list.get(0)};
        } else {
            return new int[]{list.get(0), list.get(1)};
        }
    }
    }


