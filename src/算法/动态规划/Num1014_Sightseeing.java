package 算法.动态规划;

/**
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 */
public class Num1014_Sightseeing {
    public int maxScoreSightseeingPair(int[] values) {
    int len =values.length;
    int[] dp =new int[len];
    dp[0] =values[0]+0;         //初始化
        int max =0;
        for (int j = 1; j < len; j++) {
            max=Math.max(max,dp[j-1]+values[j]-j);
            dp[j] =Math.max(dp[j-1],values[j]+j);
        }
        return max;
    }
}
