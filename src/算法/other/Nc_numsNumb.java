package 算法.other;

//因子个数
//https://www.nowcoder.com/questionTerminal/e8fb8f89f5d147ec92fd8ecfefe89b0d
import java.util.Scanner;

public class Nc_numsNumb {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int count =0;
            for (int i = 2; i <Math.sqrt(n) ; i++) {
                if (n%i ==0){
                    while (n%i ==0){
                        n=n/i;
                    }
                    count++;
                }
            }
            if (n !=1) count++;
            System.out.println(count);
        }
    }
}
