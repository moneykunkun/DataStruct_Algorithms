package newcoder;

/**

 * 链接：https://www.nowcoder.com/questionTerminal/f5805cc389394cf69d89b29c0430ff27
 * 来源：牛客网
 * 给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K]，右部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。
 * 求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？
 * 给定整数数组A和数组的大小n，请返回题目所求的答案。
 */
public class Nc_左右最值最大差 {
    /**
     * 解题思路：左右两部分的最大值中，一定包含一个全局最大值
     * 左右两边的区间一定包含 A[0] 和 A[n-1]
     * 找到数组中的全局最大值，再在区间[0,n-1]中找到一个 max-A[i]即ke
     */
    public int findMaxGap(int[] A, int n) {
        // write code here
        int mx=A[0];
        for (int i = 1; i < n; i++)
            mx =Math.max(mx,A[i]);
            return mx-Math.min(A[0],A[n-1]);
        }

}
