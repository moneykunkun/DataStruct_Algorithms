package newCoder101.堆栈队列;

import java.util.Stack;

public class BM42用两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //直接入第一个栈
        stack1.push(node);
    }


    //出队操作
    public int pop() {
        //栈2为空，将栈1元素弹出入栈2，否则直接弹出栈顶元素
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                //栈1不为空的时候，直接将栈1出栈，入栈2
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    }
