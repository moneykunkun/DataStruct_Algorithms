package newCoder101.动态规划;

public class BM63跳台阶 {
    /**
     * 青蛙跳台阶，一次要么跳2阶要么1阶
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        //初始化dp数组
        int[] dp =new int[41];
        dp[0] =1;
        dp[1] =1;
        for (int i = 2; i <=target ; i++) {
            dp[i] =dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
}
