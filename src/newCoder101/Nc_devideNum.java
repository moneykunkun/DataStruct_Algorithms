package newCoder101;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//分解因数
//https://www.nowcoder.com/questionTerminal/0f6976af36324f8bab1ea61e9e826ef5
public class Nc_devideNum {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            List<String> list =factorization(n);
            System.out.printf("%d =%s\n",n,String.join(" * ",list));
        }
    }
    //分解质因数
    private static List<String> factorization(int n) {
        List<String> ans =new ArrayList<>();
        for (int i = 2;  n>1&& i*i<=n ; i++) {
            while (n %i==0){
                ans.add(String.valueOf(i));
                n =n/i;
            }
        }
        if (n>1){
            ans.add(String.valueOf(n));
        }
        return ans;
    }
}
