package 算法.动态规划;

/**
 * 求字符串的最长回文 子序列的长度
 */
public class Num516_longestStr {
        public int longestPalindromeSubseq(String s) {
            int length =s.length();
            int[][] dp =new int[length][length];
            //初始化数组
            for(int i=0;i<length;i++){
                dp[i][i]=1;
            }
            //双向遍历遍历数组
            for(int end=length-1;end>=0;end--){
                for(int start=end+1;start<length;start++){
                    if(s.charAt(end)==s.charAt(start)){
                        dp[end][start]=dp[end+1][start-1]+2;
                    }else{
                        dp[end][start]=Math.max(dp[end+1][start],dp[end][start-1]);
                    }
                }
            }
            return dp[0][length-1];
        }
    }

