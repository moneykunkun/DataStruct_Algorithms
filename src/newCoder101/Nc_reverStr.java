package newCoder101;
import java.util.Scanner;
import java.util.Stack;

//[编程题]倒置字符串
//将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
//https://www.nowcoder.com/questionTerminal/b0ae3d72444a40e2bb14af7d4cb856ba
public class Nc_reverStr {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str =in.nextLine();
        System.out.println(reverse(str));
    }

    private static String reverse(String str) {
        Stack<String> stack =new Stack<>();
        int len =str.length();
        int start =0;
        int end =0;
        while (end<len){
            while (end<len && str.charAt(end) !=' '){
                //循环到空格结束，读取第一个单词
                end++;
            }
            //读取到的单词压入栈中
            stack.push(str.substring(start,end));
            while (end<len && str.charAt(end) ==' '){
                //遍历到下一个单词的开始位置
                end++;
            }
            //让start等于下一个单词开始的位置
            start =end;
        }
        StringBuilder sb =new StringBuilder();
        //将栈中的单词出栈 拼接字符串
        while (!stack.isEmpty()){
            sb.append(stack.pop()+' ');
        }
        String s =new String(sb);
        return s.trim();
    }
}
