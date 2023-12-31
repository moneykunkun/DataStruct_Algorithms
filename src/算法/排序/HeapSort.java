package 算法.排序;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度： nlogN
 * 稳定排序算法
 */
public class HeapSort {

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr){
        //1、先将数组调整为最大堆
        //从最后一个非叶子节点来时进行元素下沉
        for (int i=(arr.length-1-1)/2; i>=0;i--){
            //下沉终止位置就是arr.length
            siftDown(arr,i,arr.length);
        }
        //此时，数组已经被调整为最大堆，遍历数组
        for (int i = arr.length-1; i >0 ; i--) {
            //arr[0]:堆顶元素，就是最大值
            swap(arr,0,i);
            siftDown(arr,0,i);
        }
    }

    /**
     * 元素下沉操作
     * @param arr
     * @param i     当前下沉的索引
     * @param length 数组长度
     */
    private static void siftDown(int[] arr, int i, int length) {
        //只有当前节点存在左右孩子时元素才可以下沉
        while (2*i+1<length){
            int j =(i<<1)+1;
            if (j+1<length && arr[j+1]> arr[j]){
                //此时，右子树为最大值
                j=j+1;
            }
            //当前元素已经大于左右子树的最大值
            if (arr[i] > arr[j]){
                //下沉结束
                break;
            }else {
                //交换俩元素的位置
                swap(arr,i,j);
                //继续向后遍历，下沉元素
                i=j;
            }
        }
    }

    //交换元素的位置
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[]  arr={27,1,6,23,8,10,9,2,4,5,18,20,35,7,11,48};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
