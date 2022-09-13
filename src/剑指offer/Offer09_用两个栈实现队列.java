package 剑指offer;

import java.util.Stack;

/**
 * 入栈操作直接入栈1，出栈操作先判断栈2是否为空，不为空则直接出栈2
 */
public class Offer09_用两个栈实现队列 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Offer09_用两个栈实现队列() {
        this.stack1 =new Stack<>();
        this.stack2 =new Stack<>();
    }

    /**
     * 尾插
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 头删
     * @return
     */
    public int deleteHead() {
        //队列为空
        if (empty()){
            return -1;
        }
        if (stack2.isEmpty()){
            //将栈1元素全部出栈入栈2
            while (!stack1.isEmpty()){
                int pop =stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.pop();
    }

    public boolean empty(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        return false;
    }
}
