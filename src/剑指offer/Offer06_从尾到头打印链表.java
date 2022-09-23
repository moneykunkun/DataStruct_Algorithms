package 剑指offer;


import java.util.ArrayList;
import java.util.LinkedList;

public class Offer06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        if (head ==null){
            return new int[0];
        }
        ListNode temp =head;
        int i =0;
        //遍历链表确定链表的长度
        while (temp !=null){
            i++;
            temp =temp.next;
        }
        int[] array =new int[i];
        //遍历链表将链表中的值存入数组中
        while (head !=null){
            array[--i] =head.val;
            head =head.next;
        }
        return array;
    }

    /**
     * 栈的思路
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        if (head ==null){
            return new int[0];
        }
        LinkedList<ListNode> stack =new LinkedList<>();
        while (head !=null){
            stack.push(head);
            head =head.next;
        }
        int[] array =new int[stack.size()];
        for (int i=0;i<array.length;i++){
            array[i] =stack.pollFirst().val;
        }
        return array;
    }
}
