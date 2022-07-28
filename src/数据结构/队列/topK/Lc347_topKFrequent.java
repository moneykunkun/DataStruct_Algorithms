package 数据结构.队列.topK;

import java.util.*;

public class Lc347_topKFrequent {

    /**
     * 数组中出现次数前K个高的元素
     * @param nums
     * @param k
     * @return
     */
        public int[] topKFrequent(int[] nums, int k) {
            //定义一个map集合存储数组元素出现得次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            //构造一个最小堆保存最大得K个元素
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(o1) - map.get(o2);
                }
            });
            //遍历map集合，保存最大的K个元素
            for (Integer key : map.keySet()) {
                //队列还未满时，直接将元素入队
                if (queue.size() < k) {
                    queue.offer(key);
                } else if (map.get(key) > map.get(queue.peek())) {
                    //将堆顶元素出队
                    queue.poll();
                    queue.offer(key);
                }
            }
            //此时的堆就保存最大的K个元素
            int[] ret = new int[k];
            for (int i = 0; i < k; i++) {
                ret[i] = queue.poll();
            }
            return ret;
        }
    }

