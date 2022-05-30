package 数据结构.链表.leetcode;

public class Lc206_reverseList {
    /**
     * 反转链表
     * @param head
     * @return
     */
    //解法一 改变链表的指向
    public ListNode reverseList(ListNode head) {
        if (head ==null || head.next ==null){
            return head;
        }
        ListNode prev =null;
        //当前需要处理的节点，需要反转
        ListNode cur =head;
        while (cur !=null){
            //暂存一下需要处理的节点
            ListNode next =cur.next;
            cur.next =prev;
            prev =cur;
            cur =next;
        }
        return prev;
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
