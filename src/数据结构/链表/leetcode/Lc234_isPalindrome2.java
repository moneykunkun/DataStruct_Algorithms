package 数据结构.链表.leetcode;

public class Lc234_isPalindrome2 {
    public boolean isPalindrome(ListNode head) {
        //创建一个新链表，新链表是原链表的倒置
        ListNode newHead= reverse(head);
        //同步遍历两个链表，发现有值不相等时，return false
        while (head != null){
            if (head.val != newHead.val){
                return false;
            }
            head =head.next;
            newHead =newHead.next;
        }
        return true;
    }
    //反转链表
    public ListNode reverse(ListNode head){
        ListNode newHead =null;
        while (head !=null){
            ListNode node =new ListNode(head.val);
            node.next =newHead;
            newHead =node;
            head =head.next;
        }
        return newHead;
    }

}
