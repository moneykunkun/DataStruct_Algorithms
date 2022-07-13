package 数据结构.栈.leetcode;

import java.util.Stack;

public class Lc20_isValid {

    public boolean isValid(String s) {
        Stack<Character> stack =new Stack();
        for (int i = 0; i <s.length() ; i++) {
            char c =s.charAt(i);
            //碰到左括号，直接入栈
            if (c=='{' || c=='[' || c=='('){
                stack.push(c);
            }else {
                //此时，碰到的是右括号
                if (stack.isEmpty()){
                    //栈为空，表示没有和右括号匹配的左括号
                    return false;
                }
                //取出栈顶元素
                char top =stack.pop();
                if (c==')' && top !='('){
                        return false;
                }
                if (c==']' && top !='['){
                        return false;
                }
                if (c=='}' && top !='{'){
                        return false;
                }
            }
        }
        //此时字符串扫描完毕，判断当前栈是否为空即可
        return stack.isEmpty();
    }
}
