package 算法.贪心;

import java.util.Scanner;

//切割花布条
//https://www.nowcoder.com/questionTerminal/1046cd038f7a4b04b2b77b415973de1c
public class Nc_cut {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            String s =sc.next();
            String t =sc.next();
            int count =cut(s,t);
            System.out.println(count);
        }
    }

    private static int cut(String s, String t) {
        final int index = s.indexOf(t);
        if (index==-1){
            return 0;
        }
        return 1+cut(s.substring(index+t.length()),t);
    }
}
