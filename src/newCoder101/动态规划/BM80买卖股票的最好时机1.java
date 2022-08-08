package newCoder101.动态规划;

public class BM80买卖股票的最好时机1 {

    /**
     * 解法 1 贪心算法 遍历数组
     * @param prices
     * @return
     */
    public int maxProfit (int[] prices) {
        //保存数组最小值
        int min_num=prices[0];
        //保存最大获益数
        int maxProfit=0;
        for (int i = 0; i <prices.length ; i++) {
            if (prices[i] <min_num){
                //更新最小值
                min_num =prices[i];
            }else {
                maxProfit =Math.max(maxProfit,prices[i]-min_num);
            }
        }
        return maxProfit;
    }

    /**
     * 动态规划
     * 性能较差
     * @param prices
     * @return
     */
        public int maxProfit1(int[] prices) {
            int length = prices.length;
            //初始化
            int[][] dp = new int[length][2];
            //base case：第一天的时候，没股票手里利润是0，有股票的时候手里利润是-prices[0]
            dp[0][1] = -prices[0];
            dp[0][0] = 0;
            for(int i = 1;i < length; i ++){
                //手里没股票：
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
                //手里有股票
                dp[i][1] = Math.max(dp[i - 1][1],- prices[i]);
            }
            return dp[length - 1][0];
        }
    }

