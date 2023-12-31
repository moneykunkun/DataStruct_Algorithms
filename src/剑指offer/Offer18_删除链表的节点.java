package 剑指offer;

public class Offer18_删除链表的节点 {

    /**
     * 单指针解法
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val ==val){
            return head.next;
        }
        ListNode cur =head;
        //找到待删除节点的前驱节点
        while (cur.next !=null && cur.next.val !=val){
            cur =cur.next;
        }
        //当前节点就是待删除节点的前驱节点，断开节点
        if (cur.next !=null){
            cur.next =cur.next.next;
        }
        return head;
    }

    /**
     * 双指针解法
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
            if (head.val ==val){
                return head.next;
            }
            ListNode prev =head;            //待删除节点的前驱节点
            ListNode cur =head.next;
            while (cur !=null && cur.val !=val){
                prev =cur;
                cur =cur.next;
            }
            //此时，prev就是待删除节点的前驱节点删除节点
            if (cur !=null){
                prev.next =cur.next;
            }
            return head;
    }
}
