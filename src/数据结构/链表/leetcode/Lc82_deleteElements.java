package 数据结构.链表.leetcode;

public class Lc82_deleteElements {
    /**
     * 删除排序链表中的所有重复的元素 II
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
    ListNode dummyHead =new ListNode(101);
    //挂载
    dummyHead.next =head;
    ListNode prev =dummyHead;
    ListNode cur=prev.next;
    while (cur !=null){
        //第三个引用
        ListNode next =cur.next;
        if (next ==null){
            //虚拟节点不为空，cur第一个节点不为空，则只有一个节点
            return dummyHead.next;
        }else {
            //当前链表至少有两个节点
            if(cur.val !=next.val){
                //三引用同时向后移动
                prev =prev.next;
                cur =cur.next;
            }else {
                //当前节点和下一个节点相等
                while (next !=null && cur.val == next.val){
                    next =next.next;
                }
                //prev 指向重复节点的前驱
                //next指向重复节点的后继
                prev.next =next;
                //更新cur的指向
                cur=next;
            }
        }
    }
    return dummyHead.next;
    }
}
