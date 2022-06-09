package 数据结构.链表.leetcode;

//合并有序链表
//https://www.nowcoder.com/questionTerminal/d8b6b4358f774294a89de2a6ac4d9337
public class Nc_mergeList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list2==null){
            return list1;
        }
        if(list1==null){
            return list2;
        }
        if(list1.val <=list2.val){
            list1.next =Merge(list1.next,list2);
            return list1;
        }else{
            list2.next=Merge(list1,list2.next);
            return list2;
        }
    }
}
