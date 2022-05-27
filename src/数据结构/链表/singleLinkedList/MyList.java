package 数据结构.链表.singleLinkedList;

//链表的接口
public interface MyList {
        //添加元素
    void addFirst(int val);
    //尾插
    void addLast(int val);
    //在任意索引位置插入元素
    void addIndex(int index,int val);
    //通过索引获得元素
    int get(int index);
    //修改指定索引位置的元素，返回修改前的元素
    int set(int index,int newVal);
    //判断链表中是否包含指定元素
    boolean contains(int val);

    //删除元素
    void remove(int index);
    //获取链表的长度
    int size();
}
