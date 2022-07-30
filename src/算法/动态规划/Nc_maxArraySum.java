package 算法.动态规划;

/**
 *连续子数组的最大和
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=295&sfm=discuss&channel=nowcoder
 */
public class Nc_maxArraySum {

        public int FindGreatestSumOfSubArray(int[] array) {
            int n=array.length;
            int[] dp =new int[n];
            dp[0]=array[0];
            int max=dp[0];
            for(int i=1;i<array.length;i++){
                dp[i]=Math.max(dp[i-1]+array[i],array[i]);
                if(dp[i]>max){
                    max=dp[i];
                }
            }
            return max;
        }
    }

