package 剑指offer;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr){
        quickSortInternal(arr,0,arr.length-1);
    }

    private static void quickSortInternal(int[] arr, int left, int right) {
            int temp=arr[left];
            if (left>=right){
                return;
            }
            int i=left,j =right;
            while (i<j){
                while (arr[i]<=arr[j] && i<j) {
                    j--;
                }
                while (arr[i]>=arr[j] && i<j) {
                    i++;
                }
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            arr[i] =arr[left];
            arr[j] =temp;
            quickSortInternal(arr,left,i-1);
            quickSortInternal(arr,i+1,right);
    }

    public static void main(String[] args) {
        int[] arr ={1,12,8,5,9,11,3,2,6,7,0};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
