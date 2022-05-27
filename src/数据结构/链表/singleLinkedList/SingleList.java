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

    //尾插
    @Override
    public void addLast(int val) {
        addIndex(size,val);
    }

    /**
     * 在任意索引位置插入元素
     * @param index
     * @param val
     */
    @Override
    public void addIndex(int index, int val) {
        //判断索引的合法性
        if (index<0 || index >size){
            System.out.println("index illegal");
            return;
        }
        if (index==0){
            addFirst(val);
            return;
        }
        //插入元素
        Node node =new Node(val);
        //需要找到待插入元素的前驱,从头节点向后走index-1步
        Node prev =head;
        for (int i = 0; i < index-1; i++) {
            prev=prev.next;
        }
        //此时，prev指向待插入元素的前期节点
        node.next=prev.next;
        prev.next=node;
        size++;
    }

    //根据索引获取指定元素值
    @Override
    public int get(int index) {
        if (checkRange(index)){
            //index 合法
            //从头节点开始遍历链表，走到index位置
            Node node =head;
            for (int i = 0; i < index; i++) {
                node =node.next;
            }
            return node.val;
        }else {
            System.out.println("index illegal");
            return -1;
        }
    }

    //修改索引位置的元素
    @Override
    public int set(int index, int newVal) {
        if (checkRange(index)){
            Node node =head;
            for (int i = 0; i < index; i++) {
                node=node.next;
            }
            int oldVal =node.val;
            node.val =newVal;
        }else {
            System.out.println("index illegal");
            return -1;
        }
        return 0;
    }

    @Override
    public boolean contains(int val) {
        for (Node temp=head; temp !=null;temp=temp.next){
            if (temp.val==val){
                return true;
            }
        }
        return false;
    }

    //校验索引的合法性
    private boolean checkRange(int index){
        if (index<0 || index >=size){
            return false;
        }
        return true;
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

    @Override
    public int remove(int index) {
        return 0;
    }



    @Override
    public int size() {
        return 0;
    }


}
