package 数据结构.队列.queue;

import 数据结构.二叉堆.MaxHeap;

/**
 * 基于最大堆的优先级队列，值越大优先级越高
 */
public class PriorityQueue implements Queue<Integer>{
    private MaxHeap heap;

    public PriorityQueue(){
        heap =new MaxHeap();
    }
    @Override
    public void offer(Integer val) {
        heap.add(val);
    }

    @Override
    public Integer poll() {
        return heap.extractMax();
    }

    @Override
    public Integer peek() {
        return heap.peekMax();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
