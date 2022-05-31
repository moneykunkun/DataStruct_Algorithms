package 数据结构.链表.leetcode;

//快慢指针
public class Lc141_hasCycle {
    public boolean hasCycle(ListNode head) {
    ListNode fast =head;
    ListNode low =head;
    while (fast != null && fast.next != null){
        fast =fast.next.next;       //一次走两步
        low =low.next;
        //此时，fast和low指向相同的节点,成环
        if(fast ==low){
            return true;
        }
    }
    //此时，fast==null 或fast.next ==null,直线结构
        return false;
    }
}
