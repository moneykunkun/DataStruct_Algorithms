package newCoder101;

import java.util.Scanner;

/**
 * 输入两个数
 * 返回这两个数的最小公倍数
 * https://www.nowcoder.com/questionTerminal/22948c2cad484e0291350abad86136c3
 */
public class Nc_minNum {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a= in.nextInt();
        int b= in.nextInt();
        //int res=minMultiply(a,b);
        //System.out.println((a*b)/res);

        int res=gbc(a,b);
        System.out.println((a*b)/res);
    }

   /* private static int minMultiply(int a, int b) {
        if (b !=0){
            return minMultiply(b,a%b);
        }
        return a;
    }*/
    //方法二

        private static int gbc(int m,int n){
            if (m==n){
                return m;
            }
            if (m<n){
                int temp=m;
                m=n;
                n=temp;
            }
            int r;
            while ((r=m%n)>0){
                m=n;
                n=r;
            }
            return n;
        }

    }
