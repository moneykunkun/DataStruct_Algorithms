package 剑指offer;

public class Offer46_把数字翻译成字符串 {
    /**
     * 字符串
     * 将数字翻译成字符串
     * 状态转移方程的确定
     * @param num
     * @return
     */
    public int translateNum(int num) {
        //将数字转为字符串
        String s =String.valueOf(num);
        int len =s.length();
        if (len < 2) {
            return len;
        }
        char[] chars = s.toCharArray();
        // dp[i] :表示字符串s[0...i) 能翻译成小写字母的种数
        int[] dp =new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            //当前字母至少有一种翻译方法
            dp[i+1]  = dp[i];
            int curNum = 10*(chars[i-1] - '0') +(chars[i] - '0');
            if (curNum >9 && curNum < 26) {
                //当前字母与前一个字母构成一种翻译方法
                dp[i+1] =dp[i] + dp[ i-1];
            }
        }
        return dp[len];
    }
}
