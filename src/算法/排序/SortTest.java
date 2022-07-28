package 算法.排序;

/**
 * 排序的测试类
 */
public class SortTest {
    public static void main(String[] args) {
        int n=50000;
        int[] arr =SortHelper.generateRandomArray(n,0,Integer.MAX_VALUE);
        int[] arrCopy1 =SortHelper.arrCopy(arr);
        int[] arrCopy2 =SortHelper.arrCopy(arr);
        int[] arrCopy3 =SortHelper.arrCopy(arr);
        SortHelper.testSort("selectionSort",arrCopy1);
        SortHelper.testSort("heapSort",arrCopy2);
        SortHelper.testSort("bubbleSort",arrCopy3);

    }
}
