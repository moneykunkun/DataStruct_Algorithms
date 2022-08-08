package newCoder101.链表;

public class BM3链表中的节点每k个一组翻转 {

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        //边界值判断
        if(head ==null || head.next ==null || k<2) return head;
        int len =0;
        ListNode dummyHead =new ListNode(-1);
        dummyHead.next =head;
        ListNode pre=dummyHead;
        ListNode cur=head;
        ListNode temp;
        //找到链表的长度
        while (head !=null){
            len++;
            head=head.next;
        }
        //len/k次，再内部进行反转
        for (int i = 0; i < len/k; i++) {
            for (int j = 1; j <k ; j++) {
                temp =cur.next;
                cur.next =temp.next;
                temp.next =pre.next;
                pre.next =temp;
            }
            pre =cur;
            cur =cur.next;
        }
        return dummyHead.next;
    }
}
