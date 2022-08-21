package leetcode;

import java.util.*;

//前 K 个高频元素
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
public class Lc347_topKFrequent2 {

    //自定义的比较器
    private class Prior implements Comparable<Prior>{
    private int key;
    private int times;

        public Prior(int key, int times) {
            this.key = key;
            this.times = times;
        }
        @Override
        public int compareTo(Prior o) {
            return this.times-o.times;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        //定义一个map集合存储数组元素出现得次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                //i第一次出现
                map.put(i, 1);
            }
        }
        //构造一个最小堆保存最大得K个元素
      Queue<Prior> queue = new PriorityQueue<>();
        //遍历map集合，保存最大的K个元素
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (queue.size()<k){
                queue.offer(new Prior(entry.getKey(),entry.getValue()));
            }else {
                Prior prior =queue.peek();
                if (entry.getValue() <prior.times){
                    continue;
                }else {
                    //当前堆顶的元素比当前元素小
                    queue.poll();
                    queue.offer(new Prior(entry.getKey(), entry.getValue()));
                }
            }
        }
        //此时的堆就保存最大的K个元素
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll().key;
        }
        return ret;
    }
}
