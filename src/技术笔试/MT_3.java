package 技术笔试;

import java.util.LinkedList;
import java.util.Scanner;

public class MT_3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        //链表节点个数
        int num =sc.nextInt();
        //链表的头节点
        int headVal =sc.nextInt();
        //链表中节点
        int[] arr =new int[(num-1)*2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =sc.nextInt();
        }
        //头节点
        LinkedList<Integer> list =new LinkedList<>();
        list.addFirst(headVal);
        //接下来将对应的节点添加到链表对应的位置
        for (int i = 0; i < arr.length/2-1; i++) {
            list.add(arr[2*i+1],arr[2*i]);
        }
        int delNum =sc.nextInt();
        //获取待删除元素的索引
        int index =list.get(delNum);
        list.remove(index);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
