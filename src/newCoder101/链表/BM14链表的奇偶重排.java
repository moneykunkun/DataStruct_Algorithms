package newCoder101.链表;

public class BM14链表的奇偶重排 {

    public ListNode oddEvenList (ListNode head) {
            // write code here
            if (head ==null || head.next ==null){
                return head;
            }
            ListNode first =head;
            ListNode second =head.next;

            ListNode secondHead =second;
            while (second !=null && second.next !=null){
                first.next =second.next;
                first =first.next;
                second.next =first.next;
                second =second.next;
            }
            first.next =secondHead;
            return head;
        }
    }
