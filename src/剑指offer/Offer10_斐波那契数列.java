package 剑指offer;

public class Offer10_斐波那契数列 {

    /**
     * 输出斐波那契的第N项
     * @param n
     * @return
     */
    public int fib(int n){
        int a =0,b =1,sum;
        for (int i = 0; i < n; i++) {
            sum =(a+b)%1000000007;
            a=b;
            b =sum;
        }
        return a;
    }
}
