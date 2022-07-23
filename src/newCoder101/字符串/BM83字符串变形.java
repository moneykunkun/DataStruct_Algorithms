package newCoder101.字符串;

import java.util.Stack;

public class BM83字符串变形 {

    public String trans(String s, int n) {
        // write code here
        if (n == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            //大小写转换
            if (c >= 'A' && c <= 'Z') {
                sb.append(c - 'A' + 'a');
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c - 'a' + 'A');
            } else {
                //遇到空格，直接拼接
                sb.append(c);
            }
        }
        String newStr =sb.toString();
        StringBuilder stringBuilder =new StringBuilder();
        Stack<String> stack =new Stack<>();
         String[] split = newStr.split(" ");
        for (String s1 : split) {
            stack.push(s);
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop()+" ");
        }
        return stringBuilder.toString();
    }
    }
