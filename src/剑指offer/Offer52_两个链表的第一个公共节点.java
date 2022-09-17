package 剑指offer;

public class Offer52_两个链表的第一个公共节点 {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA =headA;
        ListNode pB =headB;
        while (pA !=pB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }
}
