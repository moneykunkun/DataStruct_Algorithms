package 数据结构.链表.singleLinkedList;

public class SingleList implements MyList{
    /**
     * 节点对象
     */
    class Node{
        int val;        //节点值
        Node next;      //存储下一节点对象地址

        public Node(int val){
            this.val=val;
        }
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
    public void addFirst(int val) {
        //新建一个节点
        Node node =new Node(val);
        //判断链表是否为空
        if (head ==null){
            head=node;
        }else {
            //链表中有节点，把当前节点挂在到头节点之前
            node.next=head;
            head=node;
        }
        size++;
    }

    @Override
    public String toString() {
        return "SingleList{" +
                "head=" + head +
                ", size=" + size +
                '}';
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
