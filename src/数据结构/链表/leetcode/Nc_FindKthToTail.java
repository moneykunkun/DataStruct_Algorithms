package 数据结构.链表.leetcode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Nc_FindKthToTail {

    /**
     * 快慢指针的解题思路
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast =head;
        ListNode slow=head;
        //先让快指针走k步
        for (int i = 0; i < k; i++) {
            //TODO:极端情况考虑，链表的长度小于k，走k步会发生空指针异常
           if (fast ==null) {
               return null;
           }
            fast =fast.next;
        }
        //接下来，让快慢指针同时走
        while (fast != null){
            fast =fast.next;
            slow =slow.next;
        }
        //此时，fast为空，low走到倒数第k个节点
        return slow;
    }
}
