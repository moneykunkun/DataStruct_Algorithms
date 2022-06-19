package newCoder_leetCode;

//查找和最小的 K 对数字
//https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/

import java.util.*;

public class Lc373_kSmallestPairs {
    //自定义类比较器
    static class Pair {
        //第一个数组的数
        private int  u;
        //第二个数组的数
        public int v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //1.扫描这两个数组，u来自第1个数组，v来自第2个数组
        //难点1：构造最大堆<Pair> ,pair对象中u+v的值越大，认为元素越大
        Queue<Pair> queue =new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (o2.u+o2.v)-(o1.u+o1.v);
            }
        });
        //难点2：遍历数组的终止条件，数组长度和K的较小者
        for (int i = 0; i <Math.min(nums1.length,k) ; i++) {
            for (int j = 0; j <Math.min(nums2.length, k) ; j++) {
                if (queue.size()<k){
                    queue.offer(new Pair(nums1[i],nums2[j]));
                }else {
                    //判断当前元素和堆顶元素的大小关系
                    int add =nums1[i]+nums2[j];
                    //取出堆顶元素
                    Pair pair = queue.peek();
                    if (add>(pair.u+ pair.v)){
                        //当前和大于堆顶元素
                        continue;
                    }else {
                        queue.poll();
                        queue.offer(new Pair(nums1[i],nums2[j] ));
                    }
                }
            }
        }
        //此时，优先级队列中存储了和最小的前K个pair对象
        List<List<Integer>> ret =new ArrayList<>();
        for (int i = 0; i < k&&(!queue.isEmpty()); i++) {
            List<Integer> temp =new ArrayList<>();
            Pair pair =queue.poll();
            temp.add(pair.u);
            temp.add(pair.v);
            ret.add(temp);
        }
        return ret;
    }

}
