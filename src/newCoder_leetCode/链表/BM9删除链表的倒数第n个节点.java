package newCoder_leetCode.链表;

public class BM9删除链表的倒数第n个节点 {
    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode dummyHead =new ListNode(-1);
        dummyHead.next =head;
        ListNode fast =dummyHead;
        ListNode slow =dummyHead;
        for (int i = 0; i <=n; i++) {
           if (fast ==null){
               return null;
           }
            fast=fast.next;
        }
        while (fast !=null){
            slow =slow.next;
            fast =fast.next;
        }
        //此时，slow就是待删除节点的前驱节点
        ListNode next =slow.next;
        slow.next =next.next;
        next.next =null;
        return dummyHead.next;
    }
}
