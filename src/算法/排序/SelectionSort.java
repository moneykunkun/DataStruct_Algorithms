package 算法.排序;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        for (int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                minIndex =arr[j]<arr[minIndex] ?j:minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
    int temp= arr[i];
    arr[i] =arr[j];
    arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] a={12,9,48,5,17,26,3,4,10};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
