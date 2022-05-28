package 数据结构.链表.leetcode;

public class Lc203_removeElement {
    //解法 一
    //删除当前链表中所有值为val的节点，返回删除后的链表的头节点
    /*public ListNode removeElements(ListNode head, int val) {
        //头节点就是待删除的节点
        while (head !=null && head.val ==val){
            head=head.next;
        }
        if (head ==null){
            return null;
        }else {
         //头节点不是待删除的节点，且链表不为空
         ListNode prev =head;
         while (prev.next != null){
             if (prev.next.val ==val){
                 //找到待删除的节点
                 ListNode cur =prev.next;
                 prev.next =cur.next;
             }else {
                 prev =prev.next;
             }
         }
        }
        return head;
    }*/

    //解法二
    public ListNode removeElements(ListNode head, int val) {
        //边界条件
        if (head ==null){
            return null;
        }
        //处理head及其以后的节点
        head.next =removeElements(head.next,val);
        //处理头节点
        if (head.val ==val){
            return head.next;
        }
        return head;
    }
}
