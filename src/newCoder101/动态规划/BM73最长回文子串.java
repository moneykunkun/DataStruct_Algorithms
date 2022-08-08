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
}
