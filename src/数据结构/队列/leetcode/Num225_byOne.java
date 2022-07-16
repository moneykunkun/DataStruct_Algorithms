package 数据结构.队列.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用一个队列实现，栈
 * 思路：碰到元素直接入队，再把之前的所有元素依次出队再入队
 */
public class Num225_byOne {
    private Queue<Integer> queue =new LinkedList<>();             //实际存储元素的栈
    public Num225_byOne() { }

    public void push(int x) {
    //记录队列存储元素的个数
        int size = queue.size();
        queue.offer(x);
        for (int i=0;i<size;i++){
            queue.offer(queue.poll());
        }
    }
    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
