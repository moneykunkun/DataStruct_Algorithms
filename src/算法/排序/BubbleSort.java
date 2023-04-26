package 算法.排序;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int temp ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    /**
     * 冒泡排序的优化算法
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性排序算法
     * @param arr
     */
    public static void bubbleSortPlus(int[] arr){
        int temp;
        for (int i = 0; i < arr.length ; i++) {
            //布尔值标记当前数组是否已经达到有序状态
            boolean flag =true;
            for (int j = 0; j < arr.length-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    //本次发生了交换
                    flag =false;
                }
            }
            //根据标记值判断数组是否有序，如果有序则退出，无序继续循环
            if (flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a={12,35,26,14,8,9,6,10,1,3,4};
        bubbleSortPlus(a);

        System.out.println(Arrays.toString(a));
    }
}
