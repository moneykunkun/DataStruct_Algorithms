package 数据结构.链表.leetcode;

public class Offer21_removeNthFromEnd {
    //给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode low = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        return null;
    }
}
