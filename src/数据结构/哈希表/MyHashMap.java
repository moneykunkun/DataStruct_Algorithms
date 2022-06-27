package 数据结构.哈希表;

import java.util.NoSuchElementException;

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

    //取模数，用于取得key的索引
    private int M;
    //实际存储数据的node数组
    private Node[] data;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int initCap) {
        this.data =new Node[initCap];
        this.M=initCap;
    }

    /**
     * 哈希函数
     * @param key
     * @return
     */
    public int hash(int key){
        return Math.abs(key)%M;
    }

    /**
     * 在当前的哈希表中添加一个键值对 key=value
     * @param key
     * @param value
     * @return  返回更新前的元素
     */
    public int add(int key,int value){
        //1.先对key取模，获取存储索引
        int index =hash(key);
        //2.遍历这个索引对应的链表，查看当前的key是否存在
        for (Node x =data[index]; x!= null; x=x.next){
            if (x.key ==key){
                //当前链表中key已经存在，更新可以对应的value
                int oldValue =x.value;
                x.value =value;
                return oldValue;
            }
        }
        //3.此时，key对应的元素在当前的哈希表中不存在，新建节点，头插进当前链表
        //新节点的插入位置就是data[index]
        Node node =new Node(key,value,data[index]);
        data[index] =node;
        size++;
        //4.添加一个新的元素后，查看是否需要扩容
        if(data.length*LOAD_FACTOR <=size){
            //TODO:哈希表篇需要扩容
        }
        //返回添加的元素
        return value;
    }

    /**
     * 判断当前哈希表中是否包含指定的key值
     * @param key
     * @return
     */
    public boolean containsKey(int key){
        //1.先通过key值，计算key值对应的索引
        int index =hash(key);
        //2.遍历index对应的链表，查看是否右节点的key和查询的key相等
        for (Node x=data[index]; x !=null;x =x.next){
            if (x.key ==key){
                return true;
            }
        }
        return false;
    }
    /**
     * 判断当前哈希表中是否包含指定的value值
     * @param value
     * @return
     */
    public boolean containsValue(int value){
        //遍历整个哈希表
        for (int i = 0; i < size; i++) {
            for (Node x=data[i]; x!= null; x=x.next){
                if (x.value ==value){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除哈希表中key对应的value
     * @param key
     * @return
     */
    public int remove(int key){
        //1.计算key对应的索引
        int index =hash(key);
        //2.判断头节点是否是待删除的节点
        Node head =data[index];
        if (head.key ==key){
            data[index] =head.next;
            //将头节点从链表中断开
            head.next =head =null;
            size--;
            return head.value;
        }
        //当前链表的头节点不是待删除的节点
        Node prev =head;
        //向后遍历
        while (prev.next !=null){
            if (prev.next.key==key){
                //此时，prev就是待删除节点的前驱节点
                Node cur =prev.next;
                prev.next =cur.next;
                cur.next =cur =null;
                size--;
                return cur.value;
            }
        }
        //分支走到这里的时候，表明链表中不存在这样的key对应的元素
        throw new NoSuchElementException("No Such key!");
    }


}
