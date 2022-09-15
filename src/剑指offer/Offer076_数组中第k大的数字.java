package 剑指offer;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Offer076_数组中第k大的数字 {
    /**
     * topk 构造最小堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> queue =new PriorityQueue<>();        //默认是最小堆
        for (int num : nums) {
                queue.offer(num);
                if (queue.size()>k){
                    //堆中元素大于K个，移除堆顶最小的元素
                    queue.poll();
                }
        }
        //此时，堆中就存放这最大的K个数，堆顶元素就是第K大元素
        return queue.poll();
    }


    /**
     * 快速排序解法
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];

    }

    /**
     * 快速排序思想
     * 选择一个基准值，遍历数组，将小于基准值的数放到基准值的左侧，大于基准值的放到右侧
     * 移动指针，当left==right时，更改基准值为指针相遇位置
     * 递归遍历基准值左侧和基准值右侧区间
     * @param nums
     * @param L
     * @param R
     */
    private static void quickSort(int[] nums, int L, int R) {
        //不满足
        if (L>=R){
            return;
        }
        int left =L,right=R;
        //选定一个基准值
        int pivot =nums[left];
        while (left<right){
            while (left<right &&nums[right]>=pivot){
                right--;
            }
            if (left<right){
                nums[left] =nums[right];
            }
            while (left<right && nums[left]<=pivot){
                left++;
            }
            if (left<right){
                nums[right] =nums[left];
            }
            //两指针相遇时，更新pivot
            if (left>=right){
                nums[left] =pivot;
            }
        }
        quickSort(nums,L,right-1);
        quickSort(nums,right+1,R);
    }

    public static void main(String[] args) {
        int[] arr ={9,2,1,8,3,11,7,10,6,15,12};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

