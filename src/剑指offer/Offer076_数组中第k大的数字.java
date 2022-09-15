package 剑指offer;


import java.util.PriorityQueue;

public class Offer076_数组中第k大的数字 {
    /**
     * topk 构造最小堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> queue =new PriorityQueue<>();        //默认是最小堆
        for (int num : nums) {
                queue.offer(num);
                if (queue.size()>k){
                    //堆中元素大于K个，移除堆顶最小的元素
                    queue.poll();
                }
        }
        //此时，堆中就存放这最大的K个数，堆顶元素就是第K大元素
        return queue.poll();
    }
}
