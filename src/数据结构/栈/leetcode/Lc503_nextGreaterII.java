package 数据结构.栈.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lc503_nextGreaterII {
    private Stack<Integer> stack =new Stack<>();
    private Map<Integer,Integer> map =new HashMap<>();
    public int[] nextGreaterElements(int[] nums) {
        //倒着遍历原数组
        for (int i =nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()<=nums[i]){
                    stack.pop();
            }
            int nextGreater =stack.isEmpty() ? -1:stack.peek();
            //处理完当前元素后，将当前元素入栈
            stack.push(nums[i%nums.length]);
            map.put(nums[i%nums.length],nextGreater);
        }
        int[] ret =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] =map.get(nums[i]);
        }
        return ret;
    }
}
