package newCoder101;

import java.util.HashMap;
import java.util.Map;

public class Lc138_copyRandomList {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 复制带随机指针的链表
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head ==null){
            return null;
        }
        //遍历原链表，边遍历边创建新的节点
        Map<Node,Node> nodeMap =new HashMap<>();
        for (Node x=head; x != null;x =x.next){
            //构造新的链表的节点
            Node node =new Node(x.val);
            //构造新链表和原链表的映射关系
            nodeMap.put(x,node);
        }
        //对新链表进行连接操作，原链表和新链表一一对应
        for (Node x =head ;x != null;x=x.next){
            //对于map来说，key就是原链表的节点
            //原1.next =新.next
            nodeMap.get(x).next =nodeMap.get(x.next);
            //原1.random =新.random
            nodeMap.get(x).random =nodeMap.get(x.random);
        }
        //返回新链表的头节点，就是原链表的head 的映射
        return nodeMap.get(head);
    }
}
