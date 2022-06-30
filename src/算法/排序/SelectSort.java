package 算法.排序;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度 ：O（n^2）
 * 不稳定
 */
public class SelectSort {
    public static void selectionSort(int[] arr){
        //优化
        if (arr==null || arr.length<2){
            //只有一个元素或者没有元素 直接返回
            return;
        }
        for (int i=0;i<arr.length-1;i++){
            //min对应集合最小值的索引
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                //更新最小元素的索引
                min =arr[j]<arr[min] ?j:min;
            }
            //交换索引
            swap(arr,i,min);
        }
    }

    private static void swap(int[] arr, int i, int j) {
    int temp= arr[i];
    arr[i] =arr[j];
    arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] a={12,9,48,5,17,26,3,4,10,19,2};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
