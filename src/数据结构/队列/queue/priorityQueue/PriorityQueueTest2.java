package 数据结构.队列.queue.priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * JDK中优先级队列的最小堆实现
 */
public class PriorityQueueTest2 {
    public static void main(String[] args) {
        int[] data ={1,10,12,9,6,15,7,3,8,18};
        Queue<Integer> queue =new PriorityQueue();
        for (int i: data) {
            queue.offer(i);
        }
        int[] ret  =new int[data.length];
        for (int i=0;i< ret.length;i++){
            ret[i]=queue.poll();
        }
        System.out.println(Arrays.toString(ret));
    }
}
