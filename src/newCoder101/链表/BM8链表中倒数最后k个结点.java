package newCoder101.链表;

public class BM8链表中倒数最后k个结点 {
    /**
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode fast =pHead;
         ListNode slow=pHead;
        //先让快指针走k步
        for (int i = 0; i < k; i++) {
            //TODO:极端情况考虑，链表的长度小于k，走k步会发生空指针异常
            if (fast ==null) {
                return null;
            }
            fast =fast.next;
        }
        //接下来，让快慢指针同时走
        while (fast != null){
            fast =fast.next;
            slow =slow.next;
        }
        //此时，fast为空，low走到倒数第k个节点
        return slow;
    }
    }
