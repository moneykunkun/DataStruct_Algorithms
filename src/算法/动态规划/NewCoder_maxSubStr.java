package 算法.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//牛客网
//https://www.nowcoder.com/questionTerminal/181a1a71c7574266ad07f9739f791506
public class NewCoder_maxSubStr {

    //求最长公共子串
    public static String maxSubStr(String str1,String str2){
        char[] arr1 =str1.toCharArray();
        char[] arr2 =str2.toCharArray();
        int len1 =arr1.length;
        int len2=arr2.length;
        //最长字串的起始位置
        int start =0;
        //最长字串的长度
        int maxLen =0;
        //保存状态的数组,记录的是最长公共字串的长度
        //dp[i][j]表示 以arr1第 i 个字符结尾和以arr2第 j 个字符结尾的最长公共字串的长度
        int[][] dp =new int[len1+1][len2+1];
        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                //如果第i个字符和第j个字符相等，则累加
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] =dp[i-1][j-1]+1;
                    //更新起始位置
                    if (maxLen<dp[i][j]){
                        maxLen =dp[i][j];
                        start =i-maxLen;
                    }
                }
            }
        }
        return str1.substring(start,start+maxLen);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str1;
        String str2;
        while ((str1=br.readLine()) !=null){
            str2 =br.readLine();
            if (str1.length()<str2.length()){
                System.out.println(maxSubStr(str1,str2));
            }else {
                System.out.println(maxSubStr(str2,str1));
            }
        }
    }
}

