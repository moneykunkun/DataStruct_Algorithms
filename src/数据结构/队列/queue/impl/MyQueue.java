package 数据结构.队列.queue.impl;

import 数据结构.队列.queue.Queue;

import java.util.NoSuchElementException;

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

    /**
     * 出队
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E val = head.val;
        Node node = head;
        head = head.next;
        //将原来头节点置空
        node.next = null;
        size--;
        return val;
    }

    /**
     * 取出队首元素
     * @return
     */
    @Override
    public E peek() {
        if (isEmpty()){
            throw  new NoSuchElementException("queue is empty");
        }
       return head.val;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public String toString() {
      StringBuilder sb =new StringBuilder();
      sb.append("Front [");
      for (Node x =head; x != null ;x =x.next){
          sb.append(x.val);
          if (x.next != null){
              //还没走到链表尾部
              sb.append(",");
          }
      }
      sb.append("]");
      return sb.toString();
    }
}
