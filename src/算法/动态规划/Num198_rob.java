package 算法.动态规划;

/**
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 给定一个是数组，不能选择数组相邻的数，返回数组前n个和最大值
 * 动态规划：
 * 状态转移方程：d[i] =Max(d[i-1],d[i-2]+v[i])
 */
public class Num198_rob {
        public static int rob(int[] nums) {
        int n=nums.length;
        if (n<=1) {
            return n==0?0 : nums[0];
        }
        int[] temp =new int[n];
        temp[0]=nums[0];
        temp[1] =Math.max(nums[0],nums[1]);
            for (int i = 2; i < n; i++) {
                temp[i]=Math.max(temp[i-1],nums[i]+temp[i-2]);
            }
            return temp[n-1];
        }

    public static void main(String[] args) {
        int[] a={1,2,3,1};
        System.out.println(rob(a));
    }
}
