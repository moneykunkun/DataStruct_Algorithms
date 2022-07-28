package 数据结构.队列.topK;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC373_kSmallestPairs {

    /**
     * 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数 k。
     * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
     * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
     * 链接：https://leetcode.cn/problems/find-k-pairs-with-smallest-sums
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //构造一个大根堆
        Queue<List<Integer>> queue =new PriorityQueue<>(((o1, o2) -> (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1))));
        int n1 = nums1.length;;
        int n2= nums2.length;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int sum =nums1[i]+nums2[j];
                List<Integer> list =new ArrayList<>();
                //每次存入一组数对到集合
                list.add(nums1[i]);
                list.add(nums2[j]);
                if (queue.size()<k) {
                    //队列未满，直接将集合加入队列
                    queue.offer(list);
                }else {
                    //取出堆顶元素和
                    int s =queue.peek().get(0)+queue.peek().get(1);
                    if (s>sum){
                        //堆顶元素之和大于当前数组和
                        queue.poll();
                        queue.offer(list);
                    }else {
                        break;
                    }
                }
            }
        }
        //此时优先级队列中就存储了前k小个数对
     List<List<Integer>> ans =new ArrayList<>(queue);
        return ans;
    }
}
