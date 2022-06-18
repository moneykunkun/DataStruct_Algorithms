package 数据结构.二叉堆;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 最大堆问题
 * 1.最大堆首先再结构上和满二叉树相似
 * 2.最大堆满足：根节点值 >= 子节点的值
 */
public class MaxHeap {
    //使用动态数组存储最大堆
    List<Integer> data;
    public MaxHeap(){
        //构造方法的this的调用
        this(10);
    }
    public MaxHeap(int size){
        data  = new ArrayList<>(10);
    }
    /**
     * 任意数组的堆化
     * 构造方法
     * @param arr
     */
    public MaxHeap(int[ ] arr){
        //初始化一个动态数组
        data = new ArrayList<>(arr.length);
        //1.先将数组中所有元素复制到data中
        for (int i :arr) {
            data.add(i);
        }
        //2.从最后一个元素开始不断元素下沉
        for (int i=parent(data.size()-1); i >= 0;i--){
            siftDown(i);
        }
    }

    //判空方法
    public  boolean isEmpty(){
        return data.size() == 0;
    }

    //根据索引得到父节点的索引
    public int parent(int k){
        return (k-1) >>1;
    }

    //根据索引获得左子树索引
    private  int leftChild(int k){
        return (k<<1)+1;            //相当于2k+1
    }
    //根据索引获得右子树索引
    private  int rightChild(int k){
        return (k<<1)+2;            //相当于2k+2
    }
    /**
     * 向堆中添加元素
     * @param val
     */
    public void add(int val){
        //1.直接在堆尾添加元素
        data.add(val);          //list.add() 默认是尾插
        //2.进行元素的上浮操作
        siftUp(data.size() -1);
    }

    /**
     * 元素上浮操作
     * @param k
     */
    private void siftUp(int k ){
        //上浮的终止条件：已经走到根节点 || 当前节点值 >=父节点值
        //循环的迭代条件 ： 还存在父节点值并且当前节点值 > 父节点值
        //k> 0 表示还没有走到父节点位置
        while ( k >0 && data.get(k) > data.get(parent(k))){
            //交换当前节点值和父节点值
            swap(k,parent(k));
            k = parent(k);
        }
    }

    //交换节点值
    private void swap(int i, int j) {
          int temp = data.get(i);
          data.set(i,data.get(j));
          data.set(j,temp);
    }
    /**
     * 取出堆中最大值的方法
     * @param
     * @return
     */
    public int extractMax(){
        //取值一定要判空
        if (data.isEmpty()){
            throw new NoSuchElementException("heap is empty!cannot extract");
        }
        //堆顶元素就是最大值
        int max = data.get(0);
        //1.将数组末尾的元素顶到堆顶
        int lastVal = data.get(data.size()-1);
        data.set(0, lastVal);
        //2.删除数组末尾的元素
        data.remove(data.size()-1);
        //3.进行元素的下沉操作
        siftDown(0);
        return max;
    }
    /**
     * 元素的下沉操作
     * @param k
     */
    private void siftDown(int k) {
        //还存在子树
        while (leftChild(k) < data.size()){
            int j= leftChild(k);
            //判断是否有右子树
            if ( j+1 < data.size() && data.get(j+1) > data.get(j)){
                //右子树存在且大于左子树
                j=j+1;
            }
            //此时，j就是左右子树的最大值，再和k比较
            if(data.get(k) >= data.get(j)){
                //当前节点值大于子树节点值，下沉结束
                break;
            }else {
                //交换节点值
                swap(k,j);
                k = j;
            }
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
