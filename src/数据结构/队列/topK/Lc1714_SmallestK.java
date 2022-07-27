package 数据结构.队列.topK;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc1714_SmallestK {

    public int[] smallestK(int[] arr, int k) {
    //边界条件
        if (arr.length ==0 || k==0){
        return new int[0];
    }
        //构造一个基于最大堆的优先级队列
        Queue<Integer> queue =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //遍历数组，将数组中最大的k个数放入队列中
        for (int i : arr) {
            //队列中元素小于k，直接入队
            if (queue.size()<k){
                queue.offer(i);
            }else {
                //此时，队列已满，取出堆顶元素,判断当前元素和堆顶元素的大小
                 int peek = queue.peek();
                 if (peek<i){
                     //当前元素大于堆顶元素
                     continue;
                 }else {
                     //当前元素小于堆顶元素，则一定小于堆中所有的元素，堆顶元素出队，将当前元素入队
                     queue.poll();
                     queue.offer(i);
                 }
            }
        }
        //此时，堆中就保存了最小的k个数
        int[] ret =new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] =queue.poll();
        }
        return ret;
    }
}
