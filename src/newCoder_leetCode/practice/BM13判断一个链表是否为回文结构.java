package newCoder_leetCode.practice;

public class BM13判断一个链表是否为回文结构 {
    /**
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        //1.找到链表的中间节点
        ListNode midNode=findMiddleNode(head);
        //2.反转中间链表之后的接待你
        midNode =reverseList(midNode);
        //2.遍历整个链表
        while (midNode !=null){
            if (head.val !=midNode.val){
                return false;
            }
            head =head.next;
            midNode =midNode.next;
        }
        return true;
    }

    private ListNode findMiddleNode(ListNode head) {
        //快指针，从头开始，一次走两步
        ListNode fast =head;
        //慢指针，从头开始，一次走一步
        ListNode slow =head;
        //循环终止两件 ：fast为空(偶数个节点)，fast.next为空（奇数个节点）
        while (fast != null && fast.next !=null){
            slow =slow.next;          //走一步
            fast =fast.next.next;       //走两步
        }
        return slow;
    }

    /**
     * 反转链表
     * @param midNode
     * @return
     */
    private ListNode reverseList(ListNode midNode) {
        if (midNode ==null || midNode.next ==null){
            return midNode;
        }
        ListNode cur=midNode;
        ListNode prev=null;
        while (cur !=null){
            //暂存一下头节点的下一个节点
            ListNode tail =cur.next;
            cur.next =prev;
            prev =cur;
            cur=tail;
        }
        return prev;
    }
}
