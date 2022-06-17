package 算法.动态规划;

import java.util.Arrays;

//零钱兑换
public class Num322_changeCoins {
    //自顶向上递归解法

    public int coinChange(int[] coins, int amount) {
    //定义数组
        int[] dp  =new int[amount+1];
        //给dp数组初始化为特殊值
        Arrays.fill(dp,amount+1);
        dp[0] =0;
        //外层循环遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            //内层循环再求所有选择的最小值
            for (int coin:coins){
                //状态无解，跳过
                if (i-coin <0) continue;
                //状态转移
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return (dp[amount]==amount+1) ? -1:dp[amount];
    }
}
