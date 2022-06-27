package 数据结构.哈希表;

/**
 * 自定义哈希表
 */
public class MyHashMap {

    private class Node{
        //对key求哈希运算
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //当前哈希表实际存储的元素个数
    private int size;
    //默认的哈希表的长度
    private static final int DEFAULT_CAPACITY =16;
    //默认负载因子
    private static  final double  LOAD_FACTOR =0.75;

    //实际存储数据的node数组
    private Node[] data;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int initCap) {
        this.data =new Node[initCap];
    }
}
