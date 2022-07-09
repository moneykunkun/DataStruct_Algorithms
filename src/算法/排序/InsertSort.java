package 算法.排序;

import java.util.Arrays;

/**
 * 直接插入排序
 */
public class InsertSort {
    /**
     * 直接插入排序
     * 时间复杂度:O（n^2）
     * 稳定排序算法
     * 在近乎有序的数组排序时，性能甚至优于NlogN排序算法
     * 插入排序经常用作高阶排序算法的优化手段
     * @param arr
     */

    //每次从无序区间选择一个数插入到有序区间合适的位置，直到整个数组有序
    public static void insertSort(int[] arr){
        //已排序区间[0,i)
        //无序区间[i,n]
        for (int i = 1; i < arr.length; i++) {
            //待排序区间的第一个元素是arr[i]
            //从待排序区间的第一个元素向前看，在已排序区间找到合适的位置
            for (int j = i; j >0 ; j--) {
                if (arr[j]>=arr[j-1]){
                    //相等不交换，保证稳定性
                //arr[j-1]为有序区间的最后一个元素，表明arr[j]大于整个区间，直接下次循环
                break;
                }else {
                    swap(arr,j,j-1);
                }
            }
        }
    }


    /**
     * 优化：折半插入排序
     * @param arr
     */
    public static void insertSortBs(int[] arr){
        //已排序区间[0,i)
        //无序区间[i,n]
        for (int i = 1; i < arr.length ; i++) {
            int val =arr[i];        //待插入元素
            //有序区间的索引
            int left=0;
            int right=i;
            while (left<right){
                //找到有序区间的中间位置
                int mid=left+((right-left)>>1);
                if (val<arr[mid]){
                    right=mid;
                }else {
                    left=mid+1;
                }
            }
            //搬移 left-->i 的元素
            for (int j = i; j >left ; j--) {
                arr[j]=arr[j-1];
            }
            //left就是val插入的位置
            arr[left]=val;
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp= arr[i];
        arr[i] =arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr ={12,7,4,18,5,19,30,22,8,25,68,11,30};
        int[] arr1 ={12,7,4,18,5,19,30,22,8,25,68,11,30};
        insertSort(arr);
        insertSortBs(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
