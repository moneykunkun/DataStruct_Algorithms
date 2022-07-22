package 数据结构.队列.queue.priorityQueue;

import 数据结构.队列.queue.Queue;

import java.util.Arrays;

/**
 * 自定义最大堆实现
 */
public class PriorityQueueTest {
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
