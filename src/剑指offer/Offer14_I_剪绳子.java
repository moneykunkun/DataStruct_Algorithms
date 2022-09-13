package 剑指offer;

public class Offer14_I_剪绳子 {

    /**
     * 动态规划
     * dp[i] 表示长度为i的绳子拆分后最大乘积
     * 分两种情况：
     * 之拆分两部分后不再拆分：i  和 i-j  则乘积为i*(i-j)
     * 在上述拆分的基础上对i-j继续拆分 ，则乘积为i*(dp[i-j])
     * 所以得到状态转移方程 dp[i]=Math.max(i*i(-j),i*dp[i-j])
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int[] dp =new int[n+1];
        dp[0] =dp[1] =1;
        for (int i = 2; i <= n; i++) {
            int maxNum =0;
            for (int j = 1; j < i; j++) {
                maxNum =Math.max(maxNum,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] =maxNum;
        }
        return dp[n];
    }
}
