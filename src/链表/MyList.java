package 链表;

//链表的接口
public interface MyList {
        //添加元素
    void add(int val);
    //删除元素
    int remove(int index);
    //通过索引获得元素
    int get(int index);
    //获取链表的长度
    int size();
}
