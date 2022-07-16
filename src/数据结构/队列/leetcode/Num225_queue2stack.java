package 数据结构.队列.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，
 * 并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 */
public class Num225_queue2stack {

    private  Queue<Integer> q1 =new LinkedList<>();             //实际存储元素的栈
    private  Queue<Integer> q2 =new LinkedList<>();             //辅助队列
    public Num225_queue2stack() { }

    public void push(int x) {
    //新元素直接入q2
        q2.offer(x);
        //将q1的元素直接出队入q2
        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        //q1为空，q2是直接存储元素的队列，交换q1和q2的引用
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }

    public int pop() {
    return q1.poll();
    }

    public int top() {
    return q1.peek();
    }

    public boolean empty() {
    return q1.isEmpty();
    }
}
