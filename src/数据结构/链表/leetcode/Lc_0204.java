package 数据结构.链表.leetcode;

public class Lc_0204 {
    public ListNode partition(ListNode head, int x) {
    //创建small和big链表的头节点
        ListNode smallHead =new ListNode(-1);
        ListNode bigHead =new ListNode(-1);
        //按照升序插入，所以此时需要尾插
        //分别指向两个链表的尾部
        ListNode smallTail =smallHead;
        ListNode bigTail =bigHead;
        //遍历原链表
        while (head != null){
            if (head.val <x){
                //放在small中
                smallTail.next =head;
                smallTail =head;
            }else {
                //此时head.val>x,放在big中
                bigTail.next =head;
                bigTail =head;
            }
            head =head.next;
        }
        //将bigTail尾部的原始置为空
        bigTail.next =null;
        smallTail.next =bigHead.next;
        return smallHead.next;
    }
}
