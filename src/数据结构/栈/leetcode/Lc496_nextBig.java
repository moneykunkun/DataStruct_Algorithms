package 数据结构.栈.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lc496_nextGreater {

    //单调栈
    private Stack<Integer> stack =new Stack<>();

    private Map<Integer,Integer> map =new HashMap<>();
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //1.扫描num2，维护一个单调栈，找到num2每一个元素的下一个更大元素
        //从后向前遍历，寻找第一大元素
        for (int i = nums2.length-1; i >=0 ; i--) {
            //栈不为空，且栈顶元素小于等于当前元素时,出栈
            while ( !stack.isEmpty() && stack.peek() <=nums2[i]){
                stack.pop();
            }
            int nextGreater =stack.isEmpty() ? -1:stack.peek();
            //处理完当前元素后，将当前元素入栈
            stack.push(nums2[i]);
            map.put(nums2[i],nextGreater);
        }
        //再次扫描num1，取出每个元素对应的结果集
        int[] ret =new int[nums1.length];
        for (int i = 0; i <nums1.length ; i++) {
            ret[i] =map.get(nums1[i]);
        }
        return ret;
    }
}
