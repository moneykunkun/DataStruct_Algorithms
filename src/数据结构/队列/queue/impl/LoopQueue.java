package 数据结构.队列.queue.impl;

import 数据结构.队列.queue.Queue;

import java.util.NoSuchElementException;

/**
 * 基于整形的循环队列
 */
public class LoopQueue implements Queue<Integer> {

    private Integer[] date;             //存储数据的数组
    private int head;
    //tail 指向队列队尾元素的下一个位置
    private int tail;
    private int size;

    public LoopQueue(int n){
        //循环队列，需要一个额外的空间开辟一个空间。判断队列是否已满
        date =new Integer[n+1];
    }
    @Override
    public void offer(Integer val) {
        if (isFull()){
            //队列已满
        throw new ArrayIndexOutOfBoundsException("queue is full! can not offer");
        }
        date[tail] = val;
        tail = (tail + 1) % date.length;              //移动最后元素的指针
        size++;
    }

    @Override
    public Integer poll() {
        if (isFull()){
            throw  new NoSuchElementException("queue is empty!");
        }
        Integer val =date[head];
        head =(head+1)%date.length;             //继续向后移动
        size--;
        return val;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head ==tail;
    }

    /**
     * 判断循环队列是否已满
     * @return
     */
    public boolean isFull(){
        return (tail+1)%date.length ==head;
    }
}
