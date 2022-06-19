package newCoder_leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//面试题 17.14. 最小K个数
//topK问题的两种解题思路：1.构造优先级队列，时间复杂度NlogK；2.排序，时间复杂度NlogN
//https://leetcode.cn/problems/smallest-k-lcci/

public class Lc1714_smallestK {

    public int[] smallestK(int[] arr, int k) {
    //边界值条件
        if (arr.length==0 || k==0){
            return new int[0];
        }
        //求最小的k个数，那就构造一个最大堆，jdk默认优先级队列是最小堆，此处需要定义一个最大堆的比较器
        Queue<Integer> queue =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //遍历原数组
        for (int i :arr) {
            //队列还没满时，直接将元素入队
            if (queue.size()<k){
                queue.offer(i);
            }else {
                //判断当前扫描的元素和堆顶元素的大小关系
                //若当前元素大于堆顶元素，那么当前元素一定大于堆中所有值，直接将当前元素入队
                int peek = queue.peek();
                if (i>peek){
                continue;
                }else {
                    //当前元素 < 堆顶元素，将堆顶元素出队，将较小值入队
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        //循环结束，此时队列中就保存了最小的K个数
        int[] ret =new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] =queue.poll();
        }
        return ret;
    }
}
