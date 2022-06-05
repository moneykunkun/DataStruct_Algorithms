package 数据结构.栈.leetcode;

import java.util.Stack;

/**
 * 双栈实现最小值
 */
public class Lc155_minStack {
    //实际存储元素的栈
    private Stack<Integer> s1 =new Stack<>();
    //存储最小值的栈
    private Stack<Integer> s2 =new Stack<>();
    public Lc155_minStack() {

    }

    public void push(int val) {
    s1.push(val);
    if (s2.isEmpty()){
        s2.push(val);
    }else {
        //s2不为空，取出s2栈顶元素和当前入栈元素比较，将小值入栈
        int temp =s2.peek();
        s2.push(Math.min(temp,val));
    }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
    return s1.peek();
    }

    public int getMin() {
        //最小值在s2中存储
    return s2.peek();
    }
}
