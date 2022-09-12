package 技术笔试;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str =sc.nextLine();
        System.out.println(maxLen(str));
    }
    public static int maxLen(String str){
        int max =0;
        int num =1;
        if (str.length() ==1){
            return 0;
        }
        for (int i = 1; i <str.length() ; i++) {
            char c =str.charAt(i-1);
            char cur =str.charAt(i);
            if (cur -c ==1){
                num++;
            }else {
                max=Math.max(max,num);
                num =1;
            }
        }
        max =Math.max(max,num);
        return max;
    }
}
