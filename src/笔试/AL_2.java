package 笔试;

import java.util.Arrays;

public class AL_2 {
    //剑指 Offer II 076. 数组中的第 k 大的数字

    /**
     * 解法1 直接排序API
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            heapSort(nums);
            return nums[nums.length-k];
        }
        /**
         * 堆排序
         * @param arr
         */
        public  void heapSort(int[] arr){
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
        private  void siftDown(int[] arr, int i, int length) {
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

        //交换元素的位置
        private  void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
