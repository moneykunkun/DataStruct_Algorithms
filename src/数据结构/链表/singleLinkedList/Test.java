package 数据结构.链表.singleLinkedList;

public class Test {
    public static void main(String[] args) {
        SingleList singleList =new SingleList();

        singleList.addFirst(3);
        singleList.addFirst(1);
        singleList.addFirst(3);
        singleList.addFirst(5);
        singleList.addFirst(3);
        System.out.println(singleList);
        System.out.println("----------");
        singleList.removeValueOnce(3);
        System.out.println(singleList);
    ListWithDummy list =new ListWithDummy();
    list.addIndex(0,10);
    list.addIndex(1,11);
    list.addIndex(2,12);
    list.removeIndex(0);
        System.out.println(list);
    }
}
