package 算法.动态规划;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Num45_jump {
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
