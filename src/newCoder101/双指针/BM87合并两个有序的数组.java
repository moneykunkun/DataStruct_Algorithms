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
        while (i >= 0 && j >= 0)
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        while (j >= 0)
            nums1[index--] = nums2[j--];
    }
}
