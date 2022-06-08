package 数据结构.队列.queue.impl;

public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue queue =new LoopQueue(6);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);
        System.out.println("----------");
        queue.poll();
        System.out.println(queue);
    }
}
