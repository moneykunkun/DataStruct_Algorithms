package newCoder101.动态规划;

public class BM66最长公共子串 {

    public String LCS (String str1, String str2) {
        // write code here
         char[] char1 = str1.toCharArray();
         char[] char2 = str2.toCharArray();
        int len1=char1.length;
        int len2 =char2.length;
        //标记公共子串的起始位置
        int start=0;
        //标记最长子串的长度
        int maxLen=0;
        //dp[i][j]表示 以arr1第 i 个字符结尾和以arr2第 j 个字符结尾的最长公共字串的长度
        int[][] dp =new int[len1+1][len2+1];
        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                //第一个字符和第j个字符相等
                if (char1[i-1] ==char2[j-1]){
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
}
