package 剑指offer;

import java.util.Stack;

public class Offer30_包含min函数的栈 {


    Stack<Integer> s1;
    //s2存放最小值
    Stack<Integer> s2;

    public Offer30_包含min函数的栈() {
        this.s1 =new Stack<>();
        this.s2 =new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty()){
            s2.push(x);
        }else {
            //栈2不为空，取出栈顶元素，将较小元素入栈
            int peek =s2.peek();
            s2.push(Math.min(x,peek));
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.pop();
    }

    public int min() {
    return s2.peek();
    }
}
