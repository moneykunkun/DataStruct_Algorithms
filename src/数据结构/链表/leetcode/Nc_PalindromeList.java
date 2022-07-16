package 数据结构.链表.leetcode;

//牛客
//https://www.nowcoder.com/questionTerminal/d281619e4b3e4a60a2cc66ea32855bfa
public class Nc_PalindromeList {

    public boolean chkPalindrome(ListNode A) {
        // write code here
        //先找到中间节点
        ListNode middle =middleNode(A);
        //倒置midele之后的节点
        ListNode B =reverse(middle);
        while (A !=null && B != null){
            if (A.val !=B.val){
                return false;
            }
            A =A.next;
            B =B.next;
        }
        return true;
    }
    //快慢指针找到中间节点
    public ListNode middleNode(ListNode head){
        ListNode fast =head;
        ListNode low =head;
        while (fast!= null && fast.next != null){
            //low一次走一步，fast一次走两步
            low =low.next;
            fast =fast.next.next;
        }
        return low;
    }

    //链表的转置
    public ListNode reverse(ListNode head){
        if (head ==null || head.next ==null){
            return head;
        }
        //暂存一下头节点的下一个节点
        ListNode tempHead =head.next;
        //将head之后的节点转置
        ListNode newHead =reverse(head.next);
        tempHead.next =head;
        head.next =null;
        return newHead;
    }
}
