package newCoder101.字符串;

import java.util.Stack;

public class BM83字符串变形 {

    public String trans(String s, int n) {
        StringBuilder sb =new StringBuilder();
         String[] split = s.split(" ",-1);
        for (int i = split.length-1;i >=0 ; i--) {
            char[] c =split[i].toCharArray();
            for (char c1 : c) {
                sb.append(Character.isLowerCase(c1)?Character.toUpperCase(c1):Character.toLowerCase(c1));
            }
         sb.append(" ");
        }
        return sb.substring(0,sb.length()-1).toString();
    }
    }
