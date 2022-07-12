package 数据结构.栈.leetcode;

import java.util.Stack;

/**
 * 双栈实现最小值
 * 思路：minStack 为空时，第一次入栈，将元素即入stack也入最小栈
 * minStack不为空，比较stack栈顶和minStack栈顶的元素，若比minStack栈顶的元素小，入栈minStack
 */
public class Lc155_minStack {
    //实际存储元素的栈
    private Stack<Integer> stack ;
    //存储最小值的栈
    private Stack<Integer> minStack;
    public Lc155_minStack() {
    this.stack =new Stack<>();
    this.minStack =new Stack<>();
    }

    //入栈操作
    public void push(int val) {
     this.stack.push(val);
    if (minStack.empty()){
        this.minStack.push(val);
    }else {
        //minStack不为空，取出minStack栈顶元素和当前入栈元素比较，将小值入栈
        int temp =minStack.peek();
        this.minStack.push(Math.min(temp,val));
    }
    }
    //出栈操作
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    //取出栈顶元素
    public int top() {
    return this.stack.peek();
    }

    public int getMin() {
        //最小值在s2中存储
    return this.minStack.peek();
    }
}
