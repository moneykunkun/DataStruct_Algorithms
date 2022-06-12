package 算法.回溯;

/**
 * 给定两个正整数int x,int y
 * 代表一个x乘y的网格，现有一个机器人要从网格左上角顶点走到右下角，
 * 每次只能走一步且只能向右或向下走，返回机器人有多少种走法。保证x＋y小于等于12。
 * https://www.nowcoder.com/questionTerminal/e8bb8e68434e42acbcdff0341f2a32c5
 */
public class Nc_run {
    public static int countWay(int x,int y){
        //记录返回值
        int[][] dp=new int[x][y];

        //初始化
        for (int i = 0; i <x ; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < y; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <x ; i++) {
            for (int j = 1; j <y ; j++) {
                //状态转移方程
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[x-1][y-1];
    }
}
