package 数据结构.顺序表;

import java.util.Arrays;

/**
 * 基于数组的顺序表
 */
public class MyArray {
    //存储元素的数组
    private  int[] data;
    //当前动态数组中实际存储的元素个数
    private  int size;

    public MyArray(){
        //初始化容量
        data =new int[10];
    }

    /**
     * 根据传入的大小声明数组的大小
     * @param capacity
     */
    public MyArray(int capacity){
        data =new int[capacity];
    }

    //头插法
    public  void addFirst(int val){
        //先判断数组是否已满
        if (size==data.length){
            //数组已满，需要扩容
            grow();
        }
        //数组的第一个位置空出来，将后面的元素依次后移
        for (int i =size-1; i >=0 ; i--) {
            data[i+1]=data[i];
        }
        data[0]=val;
        size++;
    }
    //尾插法
    public  void addLast(int val){
        //先判断数组是否已满
        if (size==data.length){
            //数组已满，需要扩容
            grow();
        }
        data[size] =val;
        size++;
    }
    //在指定索引位置插入
    public  void addIndex(int index,int val){
        //先判断数组是否已满
        if (size==data.length){
            //数组已满，需要扩容
            grow();
        }
        //判断插入位置的索引是否合法
        if (index<0 || index>size){
            System.out.println("index illegal！");
            return;
        }
        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=val;
        size++;
    }

    //根据元素查找索引
    public int getByValue(int val){
        //遍历索引
        for (int i = 0; i < size; i++) {
            if (data[i]==val){
                return i;
            }
        }
        //没找到
        return -1;
    }

    //判断数组是否包含指定元素
    public boolean contains(int val){
        int index=getByValue(val);
        if (index==-1){
            return false;
        }
        return true;
    }

    //根据索引查询元素
    public int get(int index){
        //判断索引的合法性
        if (index<0 || index>=size){
            System.out.println("index illegal");
            return -1;
        }
        return data[index];
    }
    //数组扩容
    private void grow() {
        int[] newDate = Arrays.copyOf(this.data, data.length << 1);
        this.data =newDate;
    }
    @Override
    public String toString() {
        String ret="[";
        for (int i = 0; i < size; i++) {
            ret +=data[i];
            if (i !=size-1){
                ret+=",";
            }
        }
        return  ret+="]";
    }
}
