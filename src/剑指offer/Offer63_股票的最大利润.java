package 剑指offer;

public class Offer63_股票的最大利润 {

    public int maxProfit(int[] prices) {
        //边界值分析
        if(prices.length ==0){
            return 0;
        }
        //记录最小值
        int minProfit =prices[0];
        //记录最大获益
        int maxProfit =0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <minProfit){
                //当前股价比最小值还小，就更新最小值
                minProfit =prices[i];
            }else {
                //当前股价比最小值大，最大获益就是当前股价-最小值
                maxProfit =Math.max(maxProfit,prices[i] -minProfit);
            }
        }
        return maxProfit;
    }
}
