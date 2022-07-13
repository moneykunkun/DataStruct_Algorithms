package 数据结构.链表.leetcode;


public class Lc19_removeNthFromEnd {

        /**
         * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //虚拟头节点的解法
            ListNode dummyHead =new ListNode(-1);
            dummyHead.next =head;

            //快慢指针都从虚拟头节点开始向后走
            ListNode fast =dummyHead;
            ListNode slow =dummyHead;

            //先让快指针走k+1步
            for (int i = 0; i <=n ; i++) {
                fast =fast.next;
            }
            while (fast !=null ){
                fast=fast.next;
                slow =slow.next;
            }
            //此时，slow就是待删除节点的前驱节点
            //node就是待删除的节点
           ListNode node =slow.next;
            slow.next =node.next;
            node.next =null;
            return dummyHead.next;
        }
}
