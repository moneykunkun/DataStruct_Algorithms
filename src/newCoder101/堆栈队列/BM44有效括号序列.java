package newCoder101.堆栈队列;

import java.util.Stack;

public class BM44有效括号序列 {


    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack =new Stack<>();

        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);
            if (c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else {
                //遇到右括号
                if (stack.isEmpty()){
                    return false;
                }
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
        return stack.isEmpty();
    }
}
