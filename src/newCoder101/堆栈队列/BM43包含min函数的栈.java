package newCoder101.堆栈队列;

import java.util.Stack;

public class BM43包含min函数的栈 {

    Stack<Integer> stack =new Stack<>();
    //存储最小元素的栈
    Stack<Integer> minStack =new Stack<>();

    //入栈操作
    public void push(int node) {
        //1.先将值入stack
        stack.push(node);
        //2.minStack为空时，再入栈minstack
        if (minStack.isEmpty()){
            minStack.push(node);
        }else {
            //取出minStack栈顶元素和当前元素比较，将较小的一方入栈
            int tmp=minStack.peek();
            this.minStack.push(Math.min(node,tmp));
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

    //获取最小值
    public int min() {
        return this.minStack.peek();
    }

}
