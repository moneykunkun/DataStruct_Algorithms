package 算法.贪心;

public class Lc121_买卖股票的最佳时机1 {

    /**
     * 某一天买，在股价最大的一天卖，即可获得最大收益
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //记录prices中的最小值
        int minNum =prices[0];
        //保存最大获益
        int maxProfit =0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <minNum){
                //更新最小值
                minNum =prices[i];
            }else {
                //如果当前股价大于最小值时，就是出售股价的最佳时机
                maxProfit =Math.max(maxProfit,prices[i] -minNum);
            }
        }
        return maxProfit;
    }
}
