package 数据结构.链表.leetcode;

//给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
public class Lc142_deleteCycle {
    public ListNode detectCycle(ListNode head) {
    ListNode fast =head;
    ListNode low =head;
    while (fast !=null && fast.next != null) {
        fast =fast.next.next;       //一次走两步
        low =low.next;              //一次走一步
        //当fast和low相遇
        if (fast ==low){
            ListNode third =head;
            while (third != low){
                third =third.next;
                low =low.next;
            }
            return low;
        }
    }
        return null;
    }
}
