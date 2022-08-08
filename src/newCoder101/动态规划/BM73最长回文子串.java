package newCoder101.动态规划;

public class BM73最长回文子串 {

    public int getLongestPalindrome (String A) {
        // write code here
        int maxLen =1;
        for (int i = 0; i < A.length(); i++) {
            maxLen =Math.max(maxLen,Math.max(fun(A,i,i),fun(A,i,i+1)));
        }
        return maxLen;
    }

    private int fun(String s, int begin, int end) {
        while (begin>=0 && end<s.length() && s.charAt(begin) ==s.charAt(end)){
            begin--;
            end++;
        }
        return end-begin -1;
    }

    /**
     * 动态规划解法
     * @param A
     * @return
     */
    public int getLongestPalindrome1 (String A) {
        // write code here
        boolean[][] dp = new boolean[A.length()][A.length()];
        int res = 0;
        for(int i = A.length()-1;i>=0;i--){
            for(int j = i;j<A.length();j++){
                if(A.charAt(i) == A.charAt(j)){
                    if(j-i <= 1) dp[i][j] = true;
                    else if (dp[i+1][j-1]) dp[i][j] = true;
                    if(dp[i][j]) res = Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
}
