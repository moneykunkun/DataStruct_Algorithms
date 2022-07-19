package newCoder101;

import java.util.Scanner;
//客似云来
//https://www.nowcoder.com/questionTerminal/3549ff22ae2c4da4890e9ad0ccb6150d
public class Nc_custom {
    private static int fib(int n){
        int[] arr =new int[80];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        if(n==0 || n==1){
            return 1;
        }
        return arr[n-1];
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int from =sc.nextInt();
            int to =sc.nextInt();
            int sum=0;
            for(int i=from;i<=to;i++){
                sum+=fib(i);
            }
            System.out.println(sum);
        }

    }
}