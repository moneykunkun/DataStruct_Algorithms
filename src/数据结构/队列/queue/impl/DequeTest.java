package 数据结构.队列.queue.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque =new ArrayDeque<>();           //基于数组实现的双端队列
        Deque<Integer> deque1 =new LinkedList<>();          //基于链表实现的双端队列
        deque.addFirst(1);
        deque.addFirst(3);
        deque.addFirst(5);
        while (!deque.isEmpty()){
            System.out.println(deque.pollLast());
        }
        deque.addLast(9);
        deque.addLast(8);
        deque.addLast(7);
        while (!deque.isEmpty()){
            System.out.println(deque.pollFirst());
        }

    }
}
