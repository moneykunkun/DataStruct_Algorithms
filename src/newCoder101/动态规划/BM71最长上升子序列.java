package newCoder101.动态规划;

public class BM71最长上升子序列 {

    public int LIS (int[] arr) {
        // write code here
        // write code here
        if(arr.length==0) {
            return 0;
        }
        int[] dp =new int[arr.length];
        dp[0] =1;
        //保存最大长度的个数
        int result =1;
        for(int i=1;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result =Math.max(result,dp[i]);
        }
        return result;
    }
}
