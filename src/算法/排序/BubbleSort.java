package 算法.排序;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if (arr ==null || arr.length<2){
            return;
        }
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j < i ; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
    int temp=arr[i];
    arr[i] =arr[j];
    arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] a={12,14,8,9,6,1,3,4};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
