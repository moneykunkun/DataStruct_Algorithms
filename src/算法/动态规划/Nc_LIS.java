package 算法.动态规划;
import java.util.*;

public class Nc_LIS {
        public static int LIS(int[] arr,int n){
            //dp数组保存以array[i]结尾的递增序列的最大长度
            int[] dp =new int[n];
            dp[0]=1;
            //保存最大长度的个数
            int result =1;
            for(int i=1;i<n;i++){
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
        public static void main(String args[]){
            Scanner sc =new Scanner(System.in);
            while(sc.hasNext()){
                int n=sc.nextInt();
                int[] arr =new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }
                System.out.println(LIS(arr,n));
            }

        }
    }

