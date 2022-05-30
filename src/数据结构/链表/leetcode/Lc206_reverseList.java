package 数据结构.链表.leetcode;

public class Lc206_reverseList {
    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        return null;
    }

    //解法二  新建一个链表，头插法
    public ListNode reverseList1(ListNode head) {
        if (head ==null || head.next ==null){
            return head;
        }
        ListNode dummyHead =new ListNode(5001);
        //遍历原链表，边头插法链表
        while (head !=null){
            ListNode node =new ListNode(head.val);
            node.next =dummyHead.next;
            dummyHead.next =node;
            head=head.next;
        }
        return dummyHead.next;
    }
}
