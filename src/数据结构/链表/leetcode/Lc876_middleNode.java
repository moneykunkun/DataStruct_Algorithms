package 数据结构.链表.leetcode;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 解题思路：快慢指针
 * 两个指针：fast、low
 * 遍历链表：fast一次走两步，low一次走一步，当fast.next为空，low即为所求位置
 */
public class Lc876_middleNode {
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
}
