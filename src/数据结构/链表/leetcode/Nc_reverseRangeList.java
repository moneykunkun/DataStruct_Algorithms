package 数据结构.链表.leetcode;

import java.util.Scanner;

//反转指定区间上范围的链表
//https://www.nowcoder.com/questionTerminal/f11155006f154419b0bef6de8918aea2
public class Nc_reverseRangeList {
    //链表的节点
    static class  Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        //链表元素的个数
        int n= in.nextInt();
        in.nextLine();
        //链表的节点值
        String nodeValue = in.nextLine();
        String[] nodes =nodeValue.split(" ");
        //尾插创建链表 虚拟头节点
        Node dummyHead =new Node(-1);
        Node tail =dummyHead;
        for (int i = 0; i <n ; i++) {
        Node node =new Node(Integer.parseInt(nodes[i]));
            tail.next =node;
            tail =node;
        }
        //获取区间范围
        String range= in.nextLine();

        //左区间
        int left =Integer.parseInt(range.split(" ")[0]);
        //右区间
        int right =Integer.parseInt(range.split(" ")[1]);
        Node newHead =reversePartList(dummyHead.next,left,right);
        //进行输出处理
        while (newHead !=null){
            System.out.print(newHead.val+" ");
            newHead =newHead.next;
        }
    }

    //反转区间范围【left，right】的链表
    private static Node reversePartList(Node head, int left, int right) {
        Node dummyHead =new Node(-1);
        //挂载虚拟头节点
        dummyHead.next =head;
        //prev 指向待反转链表的前驱节点
        Node prev =dummyHead;
        for (int i = 1; i <left ; i++) {
            prev =prev.next;
        }
        //cur就是待反转链表的第一个节点
        Node cur =prev.next;
        for (int i = left; i <right ; i++) {
            Node third =cur.next;
            //将third节点先从原链表中删除再头插到cur
            cur.next =third.next;
            //头插
           third.next =prev.next;
           prev.next=third;
        }
        return dummyHead.next;
    }
}
