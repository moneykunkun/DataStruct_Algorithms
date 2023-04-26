package 算法.排序;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSortPlus {
    /**
     * 快速排序
     * 时间复杂度：O(NlogN)~O(N^2) 平均值为：NlogN
     * 空间复杂度：O(logN)
     * 不稳定的排序算法
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 划分操作
            int pivot = partition(arr, left, right);
            // 递归排序左右子序列
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        // 选择第一个元素作为枢轴元素
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < pivot) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        quickSort(arr, 0, arr.length - 1);
        System.out.print("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
