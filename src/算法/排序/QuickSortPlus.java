package 算法.排序;

import java.util.Arrays;

public class QuickSortPlus {


    /**
     * 分区函数，找到基准值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr,int left,int right){
        //1.找临时基准值
        int tmp =arr[left];

        while (left<right){

            //从后往前看，和基准值比较
            while (left <right &&arr[right] >=tmp){
                right--;
            }
            //两指针相遇
            if (left>=right){
                arr[left] =tmp;
                break;
            }else {
                arr[left] =arr[right];
            }
            while (left <right &&arr[left] <=tmp){
                left++;
            }
            if (left>=right){
                arr[left] =tmp;
                break;
            }else {
                arr[right] =arr[left];
            }
        }
        return tmp;
    }
    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr,int left,int right){

        //找到基准值
        if (left>=right) {
            return;
        }

        //找到基准值
        int pivot=partition(arr,left,right);

        //递归基准值的左区间
        quickSort(arr,left,pivot-1);
        //递归基准值的右区间
        quickSort(arr,pivot+1,right);
        }

    public static void main(String[] args) {
        int[] arr ={1,12,3,7,2,5,10,16};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
