package 剑指offer;

public class Lc91_解码方法 {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n =s.length();
        s=" "+s;
        char[] chars = s.toCharArray();
        int[] dp = new int[n+1];
        dp[0] =1;
        //三种形成方式
        // 1. 当前位置单独成为一个 item，设为 a ,前提a 属于[1,9] 转移逻辑 dp[i] =dp[i-1]
        // 2. 当前位置与上一个位置共同形成 item ,设为 b,前提 b属于[10,26] 转移逻辑为 dp[i] =dp[i-2]
        // 3. 当前位置既能单独成 item 也能和上一位组成 item 转移逻辑 dp[i] =dp[i-1] +dp[i-2]
        for (int i = 1; i <= n ; i++) {
            int a = (chars[i]-'0');
            int b =10*(chars[i-1]-'0') + (chars[i]-'0');
            //如果 a 有效
            if (a>=1 && a<=9){
                dp[i] =dp[i-1];
            }
            if (10<=b && b<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
