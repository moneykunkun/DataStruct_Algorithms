package newCoder101;

import java.util.*;

//https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
//输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
//以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
public class Nc_badKeyBoard {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String expectedStr =null;
        String actualStr =null;
        while (in.hasNext()){
            expectedStr = in.nextLine();
            actualStr = in.nextLine();
        }
        //将输入的字符串转为大写
        expectedStr =expectedStr.toUpperCase();
        actualStr =actualStr.toUpperCase();
        //遍历实际输入的字符串，set集合存储不重复的元素
        Set<Character> actualSet =new HashSet<>();
        for (int i = 0; i < actualStr.length(); i++) {
            actualSet.add(actualStr.charAt(i));
        }
        //拿着实际输入的set集合来遍历期望输入的字符串
        //用set集合存储期望中有，实际输出没有的集合
        Set<Character> set =new HashSet<>();
        //遍历期待输出字符串
        for (int i = 0; i < expectedStr.length(); i++) {
            char c =expectedStr.charAt(i);
            //坏键就是，期待中有，但是实际输出没有的字符串
            if (!actualSet.contains(c)){
                //去重
                if (set.add(c)){
                    //c确实是期待中有，实际输出没有的，且第一次出现
                    System.out.print(c);
                }
            }
        }
        System.out.println();
    }
}
