package 面试;

import java.util.Scanner;

public class MT_2 {

    public static int  Sum(int a,int b){
        int num =0;
        while (!(a>=11 && (a-b)>=2)){
            num++;
            a++;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a =sc.nextInt();
        int b =sc.nextInt();
        int sum =Sum(a,b);
        System.out.println(sum);
    }
}
