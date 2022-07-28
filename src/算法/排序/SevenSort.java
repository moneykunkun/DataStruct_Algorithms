package 算法.排序;

/**
 * 七大排序算法
 */
public class SevenSort {

    /**
     * 冒泡排序的优化算法
     * 时间复杂度：O（N^2）
     * 稳定
     * @param arr
     */
    public static void bubbleSort(int[] arr){
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
    /**
     * 选择排序
     * 时间复杂度 ：O（n^2）
     * 不稳定
     */
    public static void selectionSort(int[] arr){
        //优化
        if (arr==null || arr.length<2){
            //只有一个元素或者没有元素 直接返回
            return;
        }
        for (int i=0;i<arr.length-1;i++){
            //min对应无序最小值的索引
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                //更新最小元素的索引
                min =arr[j]<arr[min] ?j:min;
            }
            //经过内层循环，min对应无序区间的最小值，将最小值交换到有序区间
            swap(arr,i,min);
        }
    }

    //交换元素
    private static void swap(int[] arr, int i, int j) {
        int temp= arr[i];
        arr[i] =arr[j];
        arr[j]=temp;
    }

    /**
     * 堆排序
     * 时间复杂度： nlogN
     * 稳定排序算法
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

}
