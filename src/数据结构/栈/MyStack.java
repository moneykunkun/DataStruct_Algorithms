package 数据结构.栈;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 基于数组实现的顺序栈
 * @param <E>
 */
public class MyStack<E> {

    private int size;           //栈中元素的个数
    private List<E> data =new ArrayList<>();            //实际存储元素的动态数组
    /**
     * 将元素入栈
     * @param val
     */
    public void push(E val){
        //ArrayList 默认尾插
        data.add(val);
        size++;
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public E pop(){
        if (isEmpty()){
            //栈为空，没有栈顶元素
            throw  new NoSuchElementException("stack is empty!");
        }
        //删除栈顶元素
        E val =data.remove(size-1);
        size--;
        return val;
    }

    /**
     * 返回栈顶元素但不出栈
     * @return
     */
    public E peek(){
        if (isEmpty()){
            //栈为空，没有栈顶元素
            throw  new NoSuchElementException("stack is empty!");
        }
        return data.get(size-1);
    }
    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data.get(i));
            if (i !=size-1){
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
