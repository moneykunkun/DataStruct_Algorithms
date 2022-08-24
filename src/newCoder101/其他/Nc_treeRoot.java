package newCoder101.其他;

import java.util.Scanner;

//树根计算
//现在给你一个正整数，输出它的数根。
//https://www.nowcoder.com/questionTerminal/e2422543519249f292d8435394ab82fe

public class Nc_treeRoot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            while (str.length() > 1) {
                int result = 0;
                for (int i = 0; i < str.length(); i++) {
                    result += str.charAt(i) - '0';
                    str = String.valueOf(result);
                }
                System.out.println(str);
            }
        }
    }
}
