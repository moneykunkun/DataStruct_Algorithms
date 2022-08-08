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
}
