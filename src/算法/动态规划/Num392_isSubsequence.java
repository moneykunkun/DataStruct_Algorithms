package 算法.动态规划;

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列
public class Num392_isSubsequence {
    public boolean isSubsequence(String s,String t){
        if (s.length()==0){
            return true;
        }
        int[] dp =new int[s.length()];
        for (int i = 0; i <dp.length ; i++) {
            dp[i]=-1;
        }

        int i=0;
        int j=0;

        while (i<s.length()){
            for ( j= 0; j <t.length() ; j++) {
                if (i<s.length() && s.charAt(i)==t.charAt(j)){
                    dp[i]=j;
                    i++;
                }
            }
            break;
        }
        return dp[s.length()-1] !=-1;
    }
}
