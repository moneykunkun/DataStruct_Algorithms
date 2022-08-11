package newCoder101.双指针;

public class BM87合并两个有序的数组 {

    /**
     * 解法1
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    /**
     * 解法2
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m==0){
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] =nums2[i];
            }
        }else {
            //双指针
            int i=m-1;
            int j=n-1;
            int s=m+n-1;
            while (i>=0 && j>=0){
                //遍历两个数组
                if (nums1[i]>nums2[j]){
                    nums1[s--] =nums1[i--];
                }else {
                    nums1[s--] =nums2[j--];
                }
                if (i==-1){
                    //num1数组长度为0
                    for (;j>=0;j--){
                        nums1[j] =nums2[j];
                    }
                }
            }
        }
    }
}
