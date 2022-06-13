package 算法.动态规划;

public class Lc45_jump {
    public int jump(int[] nums) {
    int len = nums.length;
    int[] dp =new int[len];
    dp[0]=0;
        for (int i = 1; i < len; i++) {
        int min =Integer.MAX_VALUE>>1;
        //看前面数的状态
            for (int j = 0; j < i ; j++) {
                //表示能走到最后数组末尾
                if (j+nums[j]>=i){
                    //状态方程
                     min=Math.min(min,dp[j]+1);
                }
            }
            dp[i] =min;
        }
        return dp[len-1];
    }
}
