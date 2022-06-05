package 数据结构.队列.queue.impl;

import 数据结构.队列.queue.Queue;

/**
 * 基于链表实现的基础队列
 */
public class MyQueue<E> implements Queue<E> {
    //实际存储元素的节点
    private class Node{
        E val;
        Node next;
        public  Node(E val){
            this.val =val;
        }
    }

    //------------------------
    private int size;           //队列元素个数
    private Node head;      //队首
    private Node tail;         //队尾

    /**
     * 尾插入队
     * @param val
     */
    @Override
    public void offer(E val) {
        Node node =new Node(val);
        if (head ==null){
            //此时链表为空
            head=tail=node;
        }else {
             tail.next =node;
            tail=node;
        }
        size++;
    }

    @Override
    public void poll() {

    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
