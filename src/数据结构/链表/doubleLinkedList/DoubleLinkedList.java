package 数据结构.链表.doubleLinkedList;

import 数据结构.链表.singleLinkedList.SingleList;

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
        Node ret = null;
        //index <size/2 （从头开始找）
        if (index < (size >> 1)) {
            ret = head;
            for (int i = 0; i < index; i++) {
                ret = ret.next;
            }
        } else {
            //从后向前遍历
            ret = tail;
            for (int i = size - 1; i > index; i--) {
                ret = ret.prev;       // tail.prev =tail;
            }
        }
        return ret;
    }

    //获取指定索引位置的元素
    public int get(int index) {
        if (rangeIndex(index)) {
            //索引合法
            return node(index).val;
        } else {
            System.out.println("index illegal");
            return -1;
        }
    }
    //判断所以的合法性
    private boolean rangeIndex(int index) {
        if (index<0 || index >=size){
            return false;
        }
        return true;
    }
    //判断链表是否包含指定元素
    public boolean contains(int val){
        //遍历链表
        for (Node x = head; x != null; x = x.next) {
            if (x.val == val) {
                return true;
            }
        }
        return false;
    }

    //根据索引修改元素值，返回修改前的值
    public int set(int index,int newVal){
        if (rangeIndex(index)){
            Node node =node(index);
            int oldVal =node.val;
            node.val =newVal;
            return oldVal;
        }else {
            System.out.println("index illegal");
            return -1;
        }
    }


    @Override
    public String toString() {
        String ret="";
        //遍历链表
        //先存储一下头节点
        Node node =head;
        while (node !=null){
            ret += node.val;
            ret+="->";
            //继续向后遍历访问
            node =node.next;
        }
        ret +="NULL";
        return  ret;
    }
}
