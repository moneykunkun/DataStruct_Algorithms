package newCoder101.其他;

import java.util.Scanner;

//输入两个字符串，返回其公共字串的长度
public class Nc_maxStrLength {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String s1= in.nextLine();
        String s2=in.nextLine();
        if (s1.length()>s2.length()){
        //保证s1是较短那个字符串，方便记录
            String temp=s1;
            s1=s2;
            s2=temp;
        }
        int len=maxLength(s1,s2);
        System.out.println(len);
    }
    //求两个字符串最长的公共长度
    private static int maxLength(String s1, String s2) {
        final char[] c1 = s1.toCharArray();
        final char[] c2 = s2.toCharArray();
        int[][] dp =new int[c1.length+1][c2.length+1];
        //初始化数组
        for (int i = 0; i <= c1.length; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j <= c2.length; j++) {
            dp[0][j]=0;
        }
        int end=0;      //最长公共字串结束的位置
        int maxLen=0;       //最长公共子串的长度
        for (int i = 1; i <= c1.length ; i++) {
            for (int j = 1; j <= c2.length ; j++) {
                if (c1[i-1]==c2[j-1]){
                    //当c1[i-1]==c2[j-1]时,dp[i][j]=dp[i-1][j-1]+1
                    dp[i][j]=dp[i-1][j-1]+1;
                    if (dp[i][j]>maxLen){
                        maxLen=dp[i][j];
                        end=i;
                    }
                }
            }
        }
        return end-maxLen;
    }
}
