package 数据结构.链表.leetcode;

//链表中倒数第k个节点
public class Offer22_getKthFromEnd {

    //要找到倒数第K个节点，单链表只能从前往后遍历，因此引入两个指针
    //先让快指针走K步，保证快慢指针的相对位置
    //当fast为空时，low即是所求的倒数第K个节点

    public ListNode getKthFromEnd(ListNode head, int k) {
        //快指针，从头开始
        ListNode fast= head;
        //慢指针
        ListNode low =head;
        //先让fast走K步，保证快慢指针的相对位置为k
        for (int i = 0; i <k ; i++) {
            fast =fast.next;
        }
        while (fast!=null){
            low =low.next;
            fast =fast.next;
        }
        return low;
    }
}
