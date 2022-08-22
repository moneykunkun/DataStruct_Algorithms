package newCoder101.其他;

import java.util.Scanner;

/**
 * 斐波那契数
 * https://www.nowcoder.com/questionTerminal/c0a4b917a15f40a49ca10532ab9019fb?commentTags=C%2FC%2B%2B
 */
public class Nc_Fib {
    public static void main(String[] args){
        long[] ans =new long[100000];
        int border =-1;
        ans[0]=1;
        ans[1]=2;
        for(int i=2;i<100000;i++){
            long next=ans[i-1]+ans[i-2];
            //输出仅6位
            if(border==-1&& ans[i]>=1000000){
                border=i+1;
            }
            ans[i] =next%1000000;
        }
        Scanner sc =new Scanner(System.in);
        while(sc.hasNextInt()){
            int num =sc.nextInt();
            if(border<num){
                System.out.printf("%d\n",ans[num-1]);
            }else{
                System.out.printf("%06d\n",ans[num-1]);
            }
        }
    }
}
