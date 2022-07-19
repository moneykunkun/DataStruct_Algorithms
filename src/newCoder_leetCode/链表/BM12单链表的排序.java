package newCoder_leetCode.链表;

public class BM12单链表的排序 {

    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // write code here
        //边界值分析
        if (head ==null || head.next ==null){
            return head;
        }
        //定义三个指针，同时向后，将链表从中间位置拆分成两个链表，再继续合并
        ListNode slow =head;
        ListNode mid =head.next;
        ListNode fast =head.next.next;
        //快指针一次走两步，满指针和mid一次走一部
        while (fast !=null && fast.next !=null){
            slow =slow.next;
            mid =mid.next;
            fast =fast.next.next;
        }
        //将左右两边的链表节点断开
        slow.next =null;
        return merge(sortInList(head),sortInList(mid));
    }

    //合并两个有序链表
    public ListNode merge(ListNode listNode1,ListNode listNode2){
        if (listNode1 ==null) return  listNode2;
        if (listNode2 ==null) return  listNode1;
        //此时两个链表都不为空
        if (listNode1.val <listNode2.val) {
            listNode1.next = merge(listNode1.next, listNode2);
            return listNode1;
        }else {
            listNode2.next=merge(listNode1,listNode2.next);
            return listNode2;
        }
    }
}
