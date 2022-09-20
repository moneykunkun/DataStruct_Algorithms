package 算法.贪心;

public class Lc122_买卖股票的最佳时机2 {

    /**
     * 最简单的思路：题目要求可以在任意天买卖股票
     * 只要后一天的股票价格比前一天高，就可以在前一天买入，后一天卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i <prices.length-1 ; i++) {
            if (prices[i]<prices[i+1]){
                profit+=(prices[i+1]-prices[i]);
            }
        }
        return profit;
    }
}
