package 算法.other;

import java.util.Scanner;

/**
 * 错排问题
 * 链接：https://www.nowcoder.com/questionTerminal/95e35e7f6ad34821bc2958e37c08918b
 * 来源：牛客网
 * NowCoder每天要给很多人发邮件。有一天他发现发错了邮件，把发给A的邮件发给了B，把发给B的邮件发给了A。
 * 于是他就思考，要给n个人发邮件，在每个人仅收到1封邮件的情况下，有多少种情况是所有人都收到了错误的邮件？
 * 即没有人收到属于自己的邮件。
 * 结论：dp[n]=(n-1)*(d[n-1]+dp[n-2])
 */
public class Nc_sendMsg {
    public static void main(String[] args) {
        //类似与斐波那契，提前将数据算好
        long[] dp =new long[21];
        dp[0]=dp[1]=0;
        dp[2]=1;
        for (int i = 3; i <21 ; i++) {
            dp[i]=(i-1)*(dp[i-1]+dp[i-2]);
        }
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
