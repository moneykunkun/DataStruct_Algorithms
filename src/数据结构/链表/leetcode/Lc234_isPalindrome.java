package 数据结构.链表.leetcode;

//  给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
public class Lc234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
    //找到中间节点
        ListNode middleNode =middleNode(head);
    //反转中间链表及其之后的链表
        ListNode r2 =reverseList(middleNode);
        while (r2 != null){
            if (head.val != r2.val){
                return false;
            }
            //继续向后遍历
            r2 =r2.next;
            head =head.next;
        }
        return  true;
    }

    public ListNode middleNode(ListNode head) {
        //快指针，从头开始，一次走两步
        ListNode fast =head;
        //慢指针，从头开始，一次走一步
        ListNode low =head;
        //循环终止两件 ：fast为空(偶数个节点)，fast.next为空（奇数个节点）
        while (fast != null && fast.next !=null){
            low =low.next;          //走一步
            fast =fast.next.next;       //走两步
        }
        return low;
    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        if (head ==null || head.next ==null){
            return head;
        }
        ListNode sec =head.next;
        //反转第二个节点之后的节点
        ListNode newHead =reverseList(head.next);
        //将sec指向head，head指向空
        sec.next =head;
        head.next =null;
        return newHead;
    }
}
