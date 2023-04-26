package 算法.排序;

import java.util.Arrays;

/**
 * 双向选择排序
 * 时间复杂度 ：O(n^2)
 * 不稳定
 * 性能优于单向选择排序
 */
public class SelectSortOP {

    /**
     * 双向选择排序
     * 每次从数组无序区间取出最大和最小的元素分别放到有序区间的末尾和开始位置
     * 重复上述步骤，直到整个数组有序
     * @param arr
     */
    public static void selectSortOP(int[] arr){
        int low=0;
        int high=arr.length-1;
        //循环遍历数组
        //low=high,表明无序区间只剩下一个元素，整个数组已经有序
        while (low<high){
            //最小值对应的索引
            int min=low;
            //最大值对应的索引
            int max=low;
            for (int i = low+1; i <=high ; i++) {
                //将最小值交换到对应位置
                if (arr[i]<arr[min]){
                min=i;
                }
                //将最大值交换到对应的位置
                if (arr[i]>arr[max]){
                max=i;
                }
            }
            //min索引对应当前无序区间的最小值，与low交换位置
            swap(arr,low,min);
            if (max==low){
                //最大值已经交换到min这个位置
                max=min;
            }
            swap(arr,high,max);
            low=low+1;
            high=high-1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr ={12,7,4,18,5,19,30,22,8};
        selectSortOP(arr);
        System.out.println(Arrays.toString(arr));
    }
}
