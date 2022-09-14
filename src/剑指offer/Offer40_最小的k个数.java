package 剑指offer;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer40_最小的k个数 {
    /**
     * 优先级队列，构造最大堆
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        //边界条件
        if (arr.length ==0 || k<=0){
            return new int[0];
        }
        //构造最大堆
        Queue<Integer> queue =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //遍历原数组
        for (int i : arr) {
            //队列未满。直接入队
            if (queue.size()<k){
                queue.offer(i);
            }else {
                //取出堆顶元素和当前元素进行判断
                int val =queue.peek();
                if (i>val){
                    //当前元素大于堆顶元素，则一定大于堆中所有的元素
                    continue;
                }else {
                    //当前元素小于堆顶元素，将堆顶元素出队，当前元素入队
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        //经过上述循环，堆中就存放着最小的k个数
        int[] ans =new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] =queue.poll();
        }
        return ans;
    }
}
