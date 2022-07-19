package newCoder101.链表;

import java.util.ArrayList;
public class JZ6从尾到头打印链表 {

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list= new ArrayList<>();
            //反转链表
            ListNode head = reverseList(listNode);
            while(head !=null){
                list.add(head.val);
                head =head.next;
            }
            return list;

        }
        //反转链表
        public static ListNode reverseList(ListNode head) {
            if (head ==null || head.next ==null){
                return head;
            }
            ListNode prev =null;
            //当前需要处理的节点，需要反转
            ListNode cur =head;
            while (cur !=null){
                //暂存一下需要处理的节点
                ListNode next =cur.next;
                cur.next =prev;
                prev =cur;
                cur =next;
            }
            return prev;
        }
    }

