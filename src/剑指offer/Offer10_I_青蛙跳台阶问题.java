package 剑指offer;

public class Offer10_I_青蛙跳台阶问题 {

    public int numWays(int n) {
        int a=1,b=1,sum;
        for (int i = 0; i < n; i++) {
            sum =(a+b)%1000000007;
            a =b ;
            b =sum;
        }
        return a;
    }
}
