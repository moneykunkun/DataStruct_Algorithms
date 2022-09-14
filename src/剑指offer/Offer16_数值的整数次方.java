package 剑指offer;

public class Offer16_数值的整数次方 {

    public double myPow(double x, int n) {
       if (x==0) return  0;
        double res =1.0;
        long b =n;
        if (b<0){
            x =1/x;
            b =-b;
        }
        while (b>0){
            if ((b&1)==1){
                res *=x;
            }
            x *=x;
            b>>=1;
        }
        return  res;
    }
}
