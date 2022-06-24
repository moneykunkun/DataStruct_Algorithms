package 数据结构.队列.leetcode;

public class Num622_MyCircularQueue {
    //指向当前队列的队首索引
    private int head;
    //指向当前队尾元素的下一个索引
    private int tail;
    private int[] data;
    public Num622_MyCircularQueue(int k) {
        //此时+1要多浪费一个空间来判断队列已满
        this.data =new int[k+1];
    }

    //入队
    public boolean enQueue(int value) {
    if (isFull()){
        return false;
    }
    //堆未满,入队
        data[tail] =value;
        tail=(tail+1)%data.length;
    return true;
    }
    //出队
    public boolean deQueue() {
    if (isEmpty()){
        return false;
    }
    //队不为空时，出队
        head=(head+1)%data.length;
    return true;
    }

    //返回队首元素
    public int Front() {
    if (isEmpty()){
        return -1;
    }
    //队不为空,返回队首元素
        return data[head];
    }

    //返回队尾元素
    public int Rear() {
    if (isEmpty()){
        return -1;
    }
    //队列不为空,获取队尾元素
        int lastIndex =tail==0 ? data.length-1 : tail-1;
    return data[lastIndex];
    }

    public boolean isEmpty() {
    return head == tail;
    }

    public boolean isFull() {
    return (tail+1)%data.length==head;
    }
}
