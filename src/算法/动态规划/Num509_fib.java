package 算法.动态规划;

public class Num509_fib {
    //动态规划
    public int fib(int n) {
    int[] dp =new int[31];
    dp[0] =0;
    dp[1] =1;
    for (int i=2;i<dp.length;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];
    }
}
