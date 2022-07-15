package 数据结构.链表.leetcode;

public class Lc206_reverseList {
    /**
     * 反转链表
     * @param head
     * @return
     */
    //解法一 改变链表的指向
    //三引用
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

    //递归解法
    public ListNode reverseList2(ListNode head) {
        if (head ==null || head.next ==null){
            return head;
        }
        ListNode sec =head.next;
        //反转第二个节点之后的节点
        ListNode newHead =reverseList(head.next);
        //将sec指向head，head指向空
        sec.next =head;
        head.next =null;
        return newHead;
    }
}
