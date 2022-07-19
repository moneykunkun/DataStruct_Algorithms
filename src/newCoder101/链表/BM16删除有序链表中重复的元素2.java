package newCoder101.链表;

public class BM16删除有序链表中重复的元素2 {
    public ListNode deleteDuplicates (ListNode head) {
        //边界值分析
        if(head ==null){
            return null;
        }
        ListNode dummyHead=new ListNode(1001);
        ListNode prev=dummyHead;
        dummyHead.next =head;
        while (prev.next !=null){
            ListNode cur=prev.next;
            while (cur.next !=null && cur.val ==cur.next.val){
                cur =cur.next;
            }
            if (cur==prev.next){
                prev =prev.next;
            }else {
                prev.next =cur.next;
            }
        }
        return dummyHead.next;
    }
}
