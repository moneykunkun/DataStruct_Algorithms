package 数据结构.队列.queue;

/**
 * 循环队列
 */
public class LoopQueue implements Queue<Integer>{

    private Integer[] date;             //存储数据的数组
    private int head;
    private int tail;
    private int size;

    public LoopQueue(int size){
        //循环队列，需要一个额外的空间开辟一个空间
        date =new Integer[size+1];
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
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 判断循环队列是否已满
     * @return
     */
    public boolean isFull(){
        return (tail+1)%date.length ==head;
    }
}
