package newCoder_leetCode.practice;

import java.util.HashSet;
import java.util.Set;

public class BM10两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set =new HashSet<>();
       //先将p1加入集合
        while (pHead1 !=null){
            set.add(pHead1);
            pHead1 =pHead1.next;
        }
        for (ListNode p =pHead2;p!=null;p=p.next){
            if (!set.add(p)){
                return p;
            }
        }
        return null;
    }
}
