package 数据结构.队列.queue;

public interface Queue<E> {

    //入队
    void offer(E val);

    //出队
    E poll();

    //返回队首元素
    E peek();

    //判断队列是否为空
    boolean isEmpty();

}
