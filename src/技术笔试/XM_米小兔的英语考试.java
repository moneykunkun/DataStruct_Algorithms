package 技术笔试;

import java.util.Scanner;

public class XM_米小兔的英语考试 {

    //可以通过增加、替换、抽出卡片的方式从字符串s->字符串 t(26个字母均可以替换)，问至少需要多少次
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s1 =sc.nextLine();
        String s2 =sc.nextLine();
        char[] char1 =s1.toCharArray();
        char[] char2 =s2.toCharArray();
        int[][] dp =new int[char1.length+1][char2.length+1];
        //初始化
        for (int i = 0; i <=char1.length ; i++) {
            dp[i][0] =i;
        }
        for (int i = 0; i <char2.length ; i++) {
            dp[0][i] =i;
        }
        for(int i=1;i<=char1.length;i++){
            for (int j = 1; j <=char2.length ; j++) {
                if (char1[i-1]==char2[j-1]){
                    dp[i][j] =dp[i-1][j-1];
                }else {
                    dp[i][j] =Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        System.out.println(dp[char1.length][char2.length]);
    }


}
