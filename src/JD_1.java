import java.util.*;

public class JD_1 {

        public static void main(String[] args){
            Scanner sc =new Scanner(System.in);
            int n=sc.nextInt();
            int k=sc.nextInt();
            String str =sc.next();
            System.out.println(reverseStr(str,k));
        }
        public static String reverseStr(String str,int k){

            String s1 =str.substring(k-1).toUpperCase();
            String s2 =str.substring(k,str.length()).toLowerCase();

            return s1+s2;
        }

    }
