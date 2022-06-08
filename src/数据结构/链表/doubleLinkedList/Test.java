package 数据结构.链表.doubleLinkedList;

public class Test {
    public static void main(String[] args) {
        DoubleLinkedList list =new DoubleLinkedList();
        list.addFirst(1);
    list.addLast(5);
    list.addLast(5);
    list.addIndex(1,5);
    list.addIndex(2,3);
    list.addIndex(5,5);

    //1 2 3 4 5 10
        System.out.println(list);
        list.removeIndexAll(5);
        System.out.println("--------------");
        System.out.println(list);
        System.out.println(list.contains(5));
        System.out.println(list.set(2,20));
        System.out.println(list.get(3));
    }
}
