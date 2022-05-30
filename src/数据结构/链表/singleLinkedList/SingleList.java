package 数据结构.链表.singleLinkedList;

public class SingleList implements MyList{
    /**
     * 节点对象
     */
    static class Node{
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
        int oldVal;
        if (checkRange(index)){
            Node node =head;
            for (int i = 0; i < index; i++) {
                node=node.next;
            }
             oldVal =node.val;
            node.val =newVal;
        }else {
            System.out.println("index illegal");
            return -1;
        }
        return oldVal;
    }
    //删除索引位置的节点
    @Override
    public void remove(int index) {
        if (checkRange(index)){
         //边界 头节点
            if (index ==0){
                Node temp =head;
                head=head.next;
                temp.next =null;
                size--;
            }else {
                //index 中间位置,找到待删除的前驱节点
                Node prev =head;
                for (int i = 0; i <index-1 ; i++) {
                    prev=prev.next;
                }
                Node cur =prev.next;        //待删除的节点
                prev.next =cur.next;
                cur.next =null;
                size--;
            }
        }else {
            System.out.println("index illegal");
        }
    }

    //删除第一个值为val的节点
    public void removeValueOnce(int val){
        //遍历节点，找到待删除的节点
        if (head !=null &&head.val ==val){
            Node temp =head;
            head =head.next;
            temp.next=null;
            size--;
        }else {
            //此时 ，头节点不是待删除的节点
            Node prev =head;
            //判断前驱节点的下一个节点是否等于val
            while (prev.next !=null){
                if (prev.next.val ==val){
                    //cur就是待删除的节点
                    Node cur =prev.next;
                    //删除cur
                    prev.next =cur.next;
                    cur.next =null;
                    size--;
                    return;
                }
             //prev不是待删除节点的前驱节点，向后遍历
                prev =prev.next;
            }
        }
    }

    //删除所有值为val的节点
    public void removeAll(int val){
        //头节点是待删除的节点
        while (head != null && head.val ==val){
            head =head.next;
            size--;
        }
        if (head ==null){
            return;
        }else {
            //链表不为空，且头节点不是待删除的节点
            Node prev =head;
            while (prev.next !=null){
                if (prev.next.val ==val){
                    Node cur =prev.next;
                    prev.next =cur.next;
                    cur.next =null;
                    size--;
                }else {
                    //前驱节点不是待删除的节点，继续向后遍历
                    prev =prev.next;
                }
            }
        }

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
        if (index<0 || index >size-1){
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
    public int size() {
        return 0;
    }
}
