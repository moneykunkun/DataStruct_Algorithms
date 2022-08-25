package newCoder101.堆栈队列;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BM45滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res =new ArrayList<>();
        //边界条件
        if (size<1 || num.length<size) return res;
        //双指针
        int left =0;
        int right=size-1;
        //遍历数组
        while (right< num.length){
            int val =calcMax(left,right,num);
            res.add(val);
            left++;
            right++;
        }
        return res;
    }
    /**
     * 计算执行区间内的最大值
     * @param left
     * @param right
     * @param num
     * @return
     */
    private int calcMax(int left, int right, int[] num) {
        int max=num[left];
        for (int i = left; i <=right ; i++) {
            if (num[i]>max){
                max =num[i];
            }
        }
        return max;
    }

    /**
     * 解法2
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows2(int [] num, int size) {
        //存放结果集的
        ArrayList<Integer> res =new ArrayList<>();
        //双端队列
        ArrayDeque<Integer> deque =new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.getLast()]<num[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            //滑动窗口移动时，将队首元素出队
            while (!deque.isEmpty() && deque.getFirst() <=i-size){
                deque.pollFirst();
            }
            if (i >=size-1){
                res.add(num[deque.getFirst()]);
            }
        }
        return res;
    }
}
