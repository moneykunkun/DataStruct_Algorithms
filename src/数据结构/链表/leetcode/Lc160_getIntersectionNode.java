package 数据结构.链表.leetcode;

//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
// 如果两个链表不存在相交节点，返回 null 。
public class Lc160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pA =headA;
    ListNode pB =headB;
        //1.相交时刚好返回交点
        //2.不相交时两个同时走到null
        while (pA != pB){
            pA = pA==null ?headB :pA.next;
            pB = pB==null ?headA :pB.next;
        }
        return pA;
    }
}
