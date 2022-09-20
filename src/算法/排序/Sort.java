package 算法.排序;

import java.util.Arrays;

public class Sort {

    public static void quickSort(int[] arr){
        quickSortInternal(arr,0,arr.length-1);
    }

    /**
     * 在区间【left,right】上进行快速排序
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSortInternal(int[] arr, int low, int high) {
        if (low < high){
            int mid = partition(arr, low, high);
            quickSortInternal(arr, low,mid-1);
            quickSortInternal(arr,mid+1,high);
        }
    }

    /**
     * 分区函数
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++){
            //比pivot小的，全部都换到前面
            if (arr[j] < pivot){
                swap(arr,j, i);
                i++;
            }
        }
        //此时i指向的元素一定大于等于pivot
        swap(arr,high, i);
        return i;
    }

    private static void swap(int[] arr,int i, int j) {
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr ={12,10,8,9,6,3,5,7,11,4,1,10,88,77,66,33,22,100};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
