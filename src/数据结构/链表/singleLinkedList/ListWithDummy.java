package 数据结构.链表.singleLinkedList;

public class ListWithDummy {
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
    //当前存储元素的个数
    private  int size;
    //虚拟头节点
    private  Node  dummyHead=new Node(-1);
    //添加方法
    public void addIndex(int index,int val){
        if (index<0 || index >size){
            System.out.println("index illegal");
            return;
        }
        Node node =new Node(val);
        //找到待插入位置的前驱节点
        Node prev =dummyHead;
        for (int i = 0; i < index; i++) {
            prev =prev.next;
        }
        //此时，prev就是待插入位置的前驱节点
        node.next =prev.next;
        prev.next =node;
        size++;
    }

    //删除节点
    public void removeIndex(int index){
        if (index< 0 || index >size){
            System.out.println("index illegal");
            return;
        }
        Node prev =dummyHead;
        for (int i=0;i<index;i++){
            prev =prev.next;
        }
        //此时，prev就是待删除节点的前驱节点
        prev.next =prev.next.next;
        size--;
    }

    @Override
    public String toString() {
        String ret ="";
        Node node =dummyHead.next;
        while (node !=null){
            ret +=node.val;
            ret+="->";
            node =node.next;
        }
        ret +="NULL";
        return ret;
    }
}
