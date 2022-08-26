package leetcode;

public class Num148_排序链表 {
    /**
     * 排序链表
     * 归并排序再合并链表
     * 快慢指针找到中间节点
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return  sortList(head,null);
    }

    /**
     * 从head->tail排序链表
     * @param head
     * @param tail
     * @return
     */
    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null || head.next ==null) {
            return head;
        }
        //只有两个链表则直接断开
        if (head .next ==tail){
            head .next =null;
            return head;
        }
        //快慢指针找到链表的中间位置
        ListNode fast =head,slow =head;
        while (fast !=tail && fast.next !=tail){
            slow =slow.next;
            fast =fast.next.next;
        }
        //中间节点
        ListNode mid =slow;
        //归并排序
        ListNode listNode1 =sortList(head,mid);
        ListNode listNode2 =sortList(mid,tail);
        //合并两个链表
        ListNode sortedList =merge(listNode1,listNode2);
        return sortedList;
    }

    /**
     * 合并两个链表
     * @param list1
     * @param list2
     * @return
     */
    private   ListNode merge(ListNode list1,ListNode list2){
        if (list1 ==null){
            return list2;
        }
        if (list2 ==null){
            return  list1;
        }
        //新建一个头节点
        ListNode head =new ListNode(0);
        ListNode cur =head;
        //开始合并链表
        while (list1 != null && list2 !=null){
            if (list1.val <= list2.val){
                cur.next =list1;
                list1 =list1.next;
            }else {
                cur.next =list2;
                list2 =list2.next;
            }
            cur =cur.next;
        }
        //遍历完，还有链表没遍历完
        if (list1 !=null){
            cur.next =list1;
        }else {
            cur.next =list2;
        }
     return head.next;
    }
}
