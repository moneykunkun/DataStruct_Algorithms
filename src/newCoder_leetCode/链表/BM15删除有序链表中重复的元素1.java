package newCoder_leetCode.链表;

public class BM15删除有序链表中重复的元素1 {

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head ==null || head.next ==null){
            return head;
        }
        ListNode prev =head;
        while (prev !=null && prev.next !=null){
            ListNode cur=prev.next;
            while (cur !=null && cur.val ==prev.val){
                cur =cur.next;
            }
            prev.next =cur;
            prev =prev.next;
        }
        return  head;
    }
}
