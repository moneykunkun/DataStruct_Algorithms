package 算法.动态规划;

import java.util.Scanner;

/**
 * 蘑菇阵
 * 链接：https://www.nowcoder.com/questionTerminal/ed9bc679ea1248f9a3d86d0a55c0be10
 * 来源：牛客网
 * 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。
 * 现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),
 * 问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
 */
public class Nc_Mushroom {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()) {
            //草地矩阵
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n + 1][m + 1];
            //蘑菇
            int k=sc.nextInt();
            while ( k !=0){
                //蘑菇的位置
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] =1;
                k--;
            }
            //从A到B的概率
            System.out.printf("%.2f\n",sover(map,n,m));
        }
    }

    /**
     * 不碰到蘑菇的概率
     * @param map   数组
     * @param n     数组的长度
     * @param m
     * @return
     */
    public static double sover(int[][] map,int n,int m){
        //描述概率的dp数组
        double[][] dp =new double[n+1][m+1];
        dp[1][1] =1.0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if (!(i==1 && j==1)){
                    dp[i][j] =dp[i-1][j]*(j==m? 1.0:0.5)+dp[i][j-1]*(i==n? 1.0:0.5);
                }
                //dp[i,j]位置可能是蘑菇
               if (map[i][j]==1){
                   dp[i][j]=0.0;
               }
            }
        }
        return dp[n][m];
    }

}
