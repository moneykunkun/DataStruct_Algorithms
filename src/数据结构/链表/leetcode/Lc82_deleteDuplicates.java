package 数据结构.链表.leetcode;

/**
 * 删除排序链表中的重复元素 II
 */

public class Lc82_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null){
            return null;
        }
        //定义一个虚拟头节点
        ListNode dummyHead =new ListNode(-101);
        ListNode p =dummyHead;
        dummyHead.next =head;
        while (p.next != null){
            ListNode q= p.next;
            while (q.next != null && q.next.val == q.val) {
                q=q.next;
            }
            if (q == p.next){
                p=p.next;
            }else {
                p.next =q.next;
            }
        }
        return dummyHead.next;
    }
}

