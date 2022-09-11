package 笔试;

import java.util.Scanner;

/**
 * 对称字符串
 */
public class MT_1 {
        public static void main(String[] args){
            Scanner sc =new Scanner(System.in);
            while(sc.hasNext()){
                String s =sc.nextLine();
                boolean flag =reverStr(s);
                if(flag){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
        public static boolean reverStr(String s){
            int len =s.length();
            StringBuilder sb =new StringBuilder(s);
             //字符串为奇数个
            if (len %2==1){
             char c =s.charAt(len/2-1);
                if (c=='A' || c=='H' || c=='W' || c=='T'||c=='U'||c=='I' ||c=='O'||c=='X'||c=='V'||c=='M' ){
                StringBuilder s1 =sb.reverse();
                if (sb.equals(s1)){
                    return true;
                }
                return false;
            }
        }
            StringBuilder s2 =sb.reverse();
            if (sb.equals(s2)){
                return true;
            }
            return false;
        }
    }

