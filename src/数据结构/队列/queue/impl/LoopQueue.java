package 数据结构.队列.queue.impl;

import 数据结构.队列.queue.Queue;

import java.util.Arrays;
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

    //入队操作
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

    //出队操作
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


    //取出队首元素
    @Override
    public Integer peek() {
        if (isEmpty()){
            throw new NoSuchElementException("queue is empty!");
        }
        Integer val =date[head];
        return val;
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

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("Front [");
        //取得最后一个元素的下标
        int lastIndex = tail==0 ?date.length-1:tail-1;
        for (int i = head; i <tail ; ) {
            sb.append(date[i]);
            if ( i != lastIndex){
                sb.append(",");
            }
            i=(i+1)%date.length;            //i继续向后遍历
        }
        sb.append("] Tail");
        return sb.toString();
    }
}
