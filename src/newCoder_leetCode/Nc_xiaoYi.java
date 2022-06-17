package newCoder_leetCode;

import java.io.IOException;
import java.util.Scanner;

//小易的升级之路
//链接：https://www.nowcoder.com/questionTerminal/fe6c73cb899c4fe1bdd773f8d3b42c3d
//来源：牛客网
public class Nc_xiaoYi {
    public static void main(String[] args) throws IOException {
        Scanner in =new Scanner(System.in);
       while (in.hasNext()){
           int n= in.nextInt();        //野怪数
           int c= in.nextInt();       //自己战力
           int[] arr =new int[n];      //存储野怪战力数组
           for (int i = 0; i < n; i++) {
               arr[i]=in.nextInt();
           }
           //遍历数组
           for (int i = 0; i < n; i++) {
               //野怪战力小于自身战力，自身战力增加野怪战力值
               if (arr[i]<=c){
                   c+=arr[i];
               }else {
                   c+=maxDivide(arr[i],c);
               }
           }
           System.out.println(c);
       }
    }

    //最大公约数
    public  static  int maxDivide(int a,int b){
        int temp=1;
        while (b!=0){
            temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}
