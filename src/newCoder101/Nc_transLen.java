package newCoder101;

import java.util.Scanner;

/**
 * 输入一个十进制数M 和一个要转换的进制 输出转换后的进制数
 */
public class Nc_transLen {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int m =in.nextInt();
        int n= in.nextInt();
        String form="0123456789ABCDEF";
        boolean flag =false;       //表示当前的数是非负数
        StringBuilder sb =new StringBuilder();
        if (m<0){
            m=-m;
            flag =true;
        }
        while ( m!=0){
            sb.append(form.charAt(m%n));
            m=m/n;
        }
        if (flag){
            sb.append("-");
        }
        String s =new String(sb.reverse());
        System.out.println(s);
    }
}
