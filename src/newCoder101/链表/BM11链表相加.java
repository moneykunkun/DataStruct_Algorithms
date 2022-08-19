package newCoder101.链表;


public class BM11链表相加 {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if (head1 ==null) return head2;
        if (head2==null) return head1;
        //将两个链表反转
        head1 =reverseList(head1);
        head2 =reverseList(head2);

        //创建新的虚拟链表
        ListNode dummyHead =new ListNode(-1);
        ListNode newHead=dummyHead;
        //进位
        int carry=0;
        while (head1 != null || head2 !=null){
            int val=carry;
            if (head1 !=null){
                val+=head1.val;
                head1 =head1.next;
            }
            if (head2 !=null){
                val+=head2.val;
                head2=head2.next;
            }
        //求出进位数
            carry =val/10;
            //将进位的数挂载到新的节点上
        dummyHead.next =new ListNode(val%10);
        dummyHead =dummyHead.next;
        }
        if (carry>0){
            //存在进位
            dummyHead.next =new ListNode(carry);
        }
        //最后将整个链表再反转回来
        return reverseList(newHead.next);
    }

    //反转链表
    private ListNode reverseList(ListNode head) {
        if (head ==null){
            return head;
        }
        ListNode cur=head;
        ListNode prev=null;
        while (cur !=null){
            ListNode tail=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tail;
        }
        return prev;
    }
}
