package 数据结构.链表.leetcode;

public class Lc21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            //边界条件
        if (list1 == null){
            return list2;
        }
        if (list2 ==null){
            return list1;
        }
        //此时，两个链表都不为空
        ListNode dummyHead =new ListNode(101);
        ListNode last =dummyHead;
        while (list1!=null && list2 !=null){
            if (list1.val<=list2.val){
                last.next =list1;
                last =list1;
                list1 =list1.next;
            }else {
                last.next =list2;
                last =list2;
                list2 =list2.next;
            }
        }
        //此时，l1或l2为空
        if (list1 ==null){
            last.next =list2;
        }else {
            last.next=list1;
        }
        return dummyHead.next;
    }

    /**
     * 递归写法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 ==null){ return list2; }
        if(list2 ==null){ return list1; }
        //此时，两个链表都不为空，开始合并
        if(list1.val <= list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next =mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}
