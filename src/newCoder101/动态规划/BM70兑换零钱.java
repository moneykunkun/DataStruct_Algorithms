package newCoder101.动态规划;

import java.util.Arrays;

public class BM70兑换零钱 {

    public int minMoney (int[] arr, int aim) {
        // write code here
        //小于1都返回0
        if(aim<1) {
            return 0;
        }
        int[] dp =new int[aim+1];
        //dp[i] 表示凑齐i元需要的货币数
        Arrays.fill(dp,aim+1);
        dp[0] =0;
        for(int i=1;i<=aim;i++){
            //每种面值的货币都要枚举
            for(int j=0;j<arr.length;j++){
                if(arr[j]<=i){
                    dp[i] =Math.min(dp[i],dp[i-arr[j]]+1);
                }
            }
        }
        //如果答案大于aim表示无解
        return dp[aim] >aim ?-1:dp[aim];
    }
}
