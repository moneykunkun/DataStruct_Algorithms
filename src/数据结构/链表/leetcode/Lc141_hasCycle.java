package 数据结构.链表.leetcode;

/**
 * 解题思路：快慢指针
 * 快指针一次走两步，慢指针一次走一步，链表若存在环，慢指针一定能追上快指针
 */
public class Lc141_hasCycle {
    public boolean hasCycle(ListNode head) {
        //快指针
        ListNode fast = head;
        //满指针
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            //一次走两步
            fast = fast.next.next;
            //一次走一步
            slow = slow.next;
            //此时，fast和low指向相同的节点,成环
            if (fast == slow) {
                return true;
            }
        }
        //此时，fast==null 或fast.next ==null,直线结构
        return false;
    }
}
