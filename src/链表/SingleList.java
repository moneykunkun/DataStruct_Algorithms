package 链表;

public class SingleList implements MyList{
    /**
     * 节点对象
     */
    class Node{
        int val;        //节点值
        Node next;      //存储下一节点对象地址
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    private  Node head;     //头节点
    private int size;           //链表元素的个数

    /**
     * 向链表中添加元素
     * @param val
     */
    @Override
    public void add(int val) {

    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
