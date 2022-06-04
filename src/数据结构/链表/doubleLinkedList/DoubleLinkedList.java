package 数据结构.链表.doubleLinkedList;

public class DoubleLinkedList {
    private int size;                  //链表的元素个数
    private Node head;          //头节点
    private Node tail;             //尾节点
    /**
     * 双向链表的节点
     */
    class Node {
        Node prev;              //指向前驱节点
        int val;
        Node next;              //指向后继节点
        public Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 链表的头插法
     * @param val
     */
    public void addFirst(int val){
        Node node = new Node(null, val, head);
        if (head == null) {
            tail = node;
        } else {
            //链表不为空
            head.prev = node;
        }
        //无论链表是否为空，最后的node节点都是最新的头节点
        head =node;
        size++;
    }

    //尾插
    public void addLast(int val){
        Node node =new Node(tail,val,null);
        if (tail ==null){
            //尾节点为空
            head =node;
        }else {
            tail.next =node;
        }
        tail =node;
        size++;
    }

    /**
     * 任意索引位置插入元素
     * @param index
     * @param val
     */
    public void addIndex(int index,int val){
        if (index< 0 || index>size){
            System.out.println("index illegal");
            return;
        }else if (index ==0) addFirst(val);
        else if (index ==size) addLast(val);
        else {
            //在中间位置插入，找到index的前驱节点
            Node prev =node(index-1);
            //l连接节点
            Node newNode =new Node(prev,val,prev.next);
            prev.next.prev =newNode;
            prev.next =newNode;
            size++;
        }
    }

    //找到index索引对应的节点
    private Node node(int index) {
        Node ret =null;
        //index <size/2 （从头开始找）
        if (index <(size>>1)){
            ret =head;
            for (int i = 0; i < index; i++) {
                ret =ret.next;
            }
        }else {
            //从后向前遍历
            ret =tail;
            for (int i = size-1; i >index ; i--) {
                tail.prev =tail;
            }
        }
        return ret;
    }
}
