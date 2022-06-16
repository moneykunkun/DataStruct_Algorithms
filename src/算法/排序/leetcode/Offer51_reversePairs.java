package 算法.排序.leetcode;

/**
 * 剑指Offer51号问题
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class Offer51_reversePairs {

    public int reversePairs(int[] nums) {
        return reversePairsHelper(nums,0,nums.length-1);
    }

    /**
     * 求数组在区间[l...r]上逆序对的个数
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int reversePairsHelper(int[] nums, int l, int r) {
        if ( l >= r){        //数组只有一个元素
            return 0;
        }
        int mid=l+(r-l)>>1;
        //递归求左区间[l...mid]的逆序对的个数
        int left=reversePairsHelper(nums,l,mid);
        //递归求右区间[mid...r]上的逆序对的个数
        int right=reversePairsHelper(nums,mid+1,r);
        if (nums[mid]>nums[mid+1]){
            //排序好的左右区间仍存在逆序
            return merge(nums,l,mid,r)+left+right;
        }
        //返回两个有序区间上所有逆序对的和
        return right+left;
    }

    /**
     * 合并两个有序区间[l...mid]和[mid+1...r]
     * 并返回合并过程中逆序对额个数
     * @param nums
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private int merge(int[] nums, int l, int mid, int r) {
        //复制一个数组
        int[] temp =new int[r-l+1];
        int count=0;
        //将原数组的值赋给新数组
        for (int i = 0; i < temp.length; i++) {
            temp[i]=nums[i+l];              //新数组和原来的数组右l个偏移量
        }
        //左侧数组的开始索引
        int i=l;
        //右侧数组的开始索引
        int j=mid+1;
        for (int k=l;k<=r;k++){
            if (i>mid) {
                //左侧区间处理完毕，放入右侧区间元素
                nums[k] = temp[j - l];
                j++;
            }else if (j>r){
                //右侧区间处理完毕，放入左侧区间元素
                nums[k] =temp[i-l];
                i++;
            }else if (temp[i-l]<=temp[j-l]){
                //左区间的元素< 右区间的元素，此时不构成逆序对
                nums[k] =temp[i-l];
                i++;
            }else {
                //此时，右区间的元素> 左区间的元素，构成逆序对
                //逆序对的个数 =mid-i+1
                count+=(mid-i)+1;
                nums[k]=temp[j-l];
                j++;
            }
        }
        return count;
    }
}
