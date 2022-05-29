package 算法.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//牛客网
//链接：https://www.nowcoder.com/questionTerminal/3959837097c7413a961a135d7104c314
public class Nc_minDistance {

    //求两个字符转的最小距离
    public static int getDistance(String str1,String str2){
         char[] w1 = str1.toCharArray();
         char[] w2 = str2.toCharArray();
         int len1 = w1.length;
         int len2 =w2.length;
        //dp数组
        int[][] dist =new int[len1+1][len2+1];
        //初始化数组
        for (int i=0;i<=len1;i++){
            dist[i][0]=i;
        }
        for (int j = 0; j <= len2; j++) {
            dist[0][j] =j;
        }
        for (int i = 0; i <=len1 ; i++) {
            for (int j = 0; j <=len2 ; j++) {
                //状态方程：F[i][j] 表示把s1的前 i 个 字符转成s2的前j个字符需要的次数
                //字符转换可以分为 插入、删除、替换 从三种策略中选择最少的
                //首先求出插入和删除需要的最小次数
                dist[i][j] =Math.min(dist[i-1][j],dist[i][j-1])+1;
                //再和替换比较
                if (w1[i-1]==w2[j-1]){
                    //第i个字符和第j个字符相等，不需要替换
                    dist[i][j] =Math.min(dist[i][j],dist[i-1][j-1]);
                }else {
                    dist[i][j] =Math.min(dist[i][j],dist[i-1][j-1]+1);
                }
            }
        }
        return dist[len1][len2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str1;
        while ((str1 =br.readLine() ) !=null){
         String str2=br.readLine();
            System.out.println(getDistance(str1,str2));
        }
    }
}
