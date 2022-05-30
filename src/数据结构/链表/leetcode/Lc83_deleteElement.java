package 数据结构.链表.leetcode;

public class Lc83_deleteElement {

    /**
     * 删除排序链表中的重复元素，只保留一次
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
    ListNode prev=head;
    while (prev !=null && prev.next !=null){
        ListNode cur =prev.next;
        while (cur !=null && cur.val==prev.val){
            cur=cur.next;
        }
        prev.next =cur;
        prev=prev.next;
     }
    return head;
    }
}
