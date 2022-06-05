package 数据结构.队列.queue.impl;

import 数据结构.队列.queue.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue =new MyQueue<>();
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        System.out.println(queue);
    }
}
