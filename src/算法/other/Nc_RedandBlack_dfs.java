package 算法.other;

import java.util.Scanner;

/**
 * 牛客网
 * https://ac.nowcoder.com/questionTerminal/5017fd2fc5c84f78bbaed4777996213a?answerType=1
 * 深度优先遍历
 * 有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。
 * 你站在其中一块黑色的瓷砖上，只能向相邻的（上下左右四个方向）黑色瓷砖移动。请写一个程序，计算你总共能够到达多少块黑色的瓷砖。
 */
public class Nc_RedandBlack_dfs {

    //标记上下左右四个方向的数组
    static int[][] direction ={{-1,0},{1,0},{0,-1},{0,1}};
    static int count =0;

    //深度优先遍历
    public static void dfs(char[][] map,int m,int n,int x,int y){
        //遇到白色瓷砖，直接返回
        if ('#' == map[x][y]){
            return;
        }
        //遇到黑色瓷砖
        count++;
        //遍历完后，将遍历过的瓷砖进行标记
        map[x][y]='#';

        //继续向上下左右四个方向进行遍历
        for (int i=0;i<4;i++){
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];

            //检查，防止方向越界
            if (nx>=0 && nx<m && ny>=0 && ny<n){
                dfs(map,m,n,nx,ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int m= sc.nextInt();
            int n= sc.nextInt();
            //接收地图数据，并找到起始位置
            char[][] map =new char[m][n];
            int x=0,y=0;
            for (int i = 0; i <m ; i++) {
                String s=sc.next();
                for (int j = 0; j < n; j++) {
                map[i][j] =s.charAt(j);
                //找到起始位置
                    if ('@'==map[i][j]){
                        x=i;
                        y=j;
                    }
                }
            }
            //静态变量重新置零
            count=0;
            dfs(map,m,n,x,y);
            System.out.println(count);
        }
    }
}
