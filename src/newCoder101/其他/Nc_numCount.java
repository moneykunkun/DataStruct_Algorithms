package newCoder101.其他;
import java.util.Scanner;
/**
 * 链接：https://www.nowcoder.com/questionTerminal/e8fb8f89f5d147ec92fd8ecfefe89b0d?f=discussion
 * 来源：牛客网
 * 一个正整数可以分解成一个或多个数组的积。例如36=2*2*3*3，即包含2和3两个因子。
 * NowCoder最近在研究因子个数的分布规律，现在给出一系列正整数，他希望你开发一个程序输出每个正整数的因子个数
 */
public class Nc_numCount {
        // write your code here

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {
                int n = in.nextInt();
                int count = 0;
                for(int i = 2;i <= Math.sqrt(n);i++){
                    if(n % i == 0){
                        while(n % i == 0){
                            n /= i;
                        }
                        count++;
                    }
                }
                if(n != 1){
                    count++;
                }
                System.out.println(count);
            }
        }
    }

