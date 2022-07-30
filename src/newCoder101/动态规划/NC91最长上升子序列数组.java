package newCoder101.动态规划;

import java.util.Arrays;

public class NC91最长上升子序列数组 {

    /**动态规划
     *状态定义：dp[i]dp[i]dp[i]表示以i位置元素结尾的最长上升子序列长度。
     * 状态初始化：以每个位置结尾的上升子序列长度至少为1。
     * 状态转移：遍历arr数组，假设当前位置为i，比较当前位置i之前的每一个元素与当前位置元素的大小，
     * 如果小于当前位置元素arr[i]arr[i]arr[i]，说明可以接在arr[i]arr[i]arr[i]前面。
     * 即dp[i]=Math.max(dp[i],dp[j]+1)dp[i]=Math.max(dp[i],dp[j]+1)dp[i]=Math.max(dp[i],dp[j]+1)。
     * @param arr
     * @return
     */
    public int[] LIS (int[] arr) {
            int n=arr.length;
            //dp[i]表示以i位置元素结尾的最长上升子序列长度
            int[] dp=new int[n+1];
            //初始化为1
            Arrays.fill(dp,1);
            //记录最长子序列的长度
            int len=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    //如果小于arr[i]，则可以接在arr[i]前面
                    if(arr[j]<arr[i]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                //计算最长子序列的长度
                len=Math.max(len,dp[i]);
            }

            int[] res=new int[len];
            //从后往前确定目标子序列的每一个值
            for(int i=n-1;i>=0;i--){
                if(dp[i]==len){
                    res[--len]=arr[i];
                }
            }
            return res;
        }
    }
