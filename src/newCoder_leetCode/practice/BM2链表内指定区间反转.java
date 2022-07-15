package newCoder_leetCode.practice;

public class BM2链表内指定区间反转 {
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // 定义一个虚拟头节点
        ListNode dummyHead =new ListNode(1001);
        dummyHead.next =head;
        //先找到待反转区间的前驱
        ListNode prev =dummyHead;
        for(int i=0;i<m-1;i++){
            prev =prev.next;
        }
        //此时，prev就是待反转链表的前驱节点
        ListNode cur=prev.next;
        ListNode next;
        for(int i=0;i<n-m;i++){
            next = cur.next;
            cur.next =next.next;
            next .next = prev.next;
            prev.next = next ;
        }
        return dummyHead.next;
    }
}
