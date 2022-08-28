package 算法.排序;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 快速排序
 *
 * 时间复杂度：NlogN
 * 最坏情况O（N^2）
 * 空间复杂度:
 * 不稳定
 */
public class QuickSort {

    //快速排序的基准值选择--随机数选择
    private static final ThreadLocalRandom random =ThreadLocalRandom.current();
    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr){
        quickSortInternal(arr,0,arr.length-1);
    }
    /**
     * 在区间【l，r】上进行快速排序
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSortInternal(int[] arr, int l, int r) {
        //先获取分区点：经过分区函数后，某个元素落在了最终的位置
        //分区点左侧元素均小于该元素，分区点右侧元素均大于等于该元素
        if (r-l<=15){
            //优化点，在元素小于15时，直接插入排序优化算法
            insertSort(arr,l,r);
            return;
        }
        //分区函数,最终返回在[l，r]区间上分区点元素索引
        int p=partition(arr,l,r);
        //在分区元素左侧区间递归
        quickSortInternal(arr,l,p-1);
        //在分区元素右侧区间递归
        quickSortInternal(arr,p+1,r);
    }

    /**
     * 分区函数
     * @param arr
     * @param l
     * @param r
     * @return 分区点索引
     */
    private static int partition(int[] arr, int l, int r) {
        //随机在当前数组中选择一个数作为基准值
        int randomIndex =random.nextInt(l,r);
        swap(arr,l,randomIndex);
        //基准值
        int val=arr[l];
        //arr[l+1...j] < val
        //arr[j+1...i) >= val
        // i 表示当前正在扫描的元素索引
        int j=l;
        for (int i = l+1; i <=r ; i++) {
            if (arr[i] <val){
                swap(arr,i,j+1);
                j++;
            }
        }
        //经过上述循环，就把小于val的元素换到了分区点的左侧
        //此时，将基准值和最后一个小于v的元素交换，基准值就落在了最终的位置
        swap(arr,j,l);
        return j;
    }

    /**
     * 交换数组中 i 和 j 的索引
     * @param arr
     * @param j
     * @param i
     */
    private static void swap(int[] arr, int i, int j ) {
        int temp=arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
    /**
     * 在区间[l , r]上进行插入排序
     * @param arr
     * @param l
     * @param r
     */
    private static void insertSort(int[] arr, int l, int r) {
        for (int i=l+1;i<=r;i++){
            for (int j=i; j>l&& arr[j]<arr[j-1];j--){
                swap(arr,j,j-1);
            }
        }
    }

    /**
     * 借助栈实现的非递归分治快排
     * @param
     */
    public static void quickSortNonRecursion(int[] arr){
        //栈中保存当前集合的开始位置和终止位置
        Deque<Integer> stack =new ArrayDeque<>();
        int l =0;
        int r =arr.length-1;
        //注：栈结构先入后出，先把终止位置入栈
        stack.push(r);
        stack.push(l);
        while ( ! stack.isEmpty()){
            //栈不为空，说明子区间还有元素没有处理完
            int  left  =stack.pop();
            int right =stack.pop();
            if (left >= right){
                //区间只有一个元素
                continue;
            }
            //获取数组的分区点
            int p=partition(arr,left,right);
            //依次将右侧区间的开始和结束入栈
            stack.push(right);
            stack.push(p+1);
            //再将左侧区间的开始和结束入栈
            stack.push(p-1);
            stack.push(left);
        }
    }
    public static void main(String[] args) {
        int[] arr={9,12,8,10,7,16,18,2,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
