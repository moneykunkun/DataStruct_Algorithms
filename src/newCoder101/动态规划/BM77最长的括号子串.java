package newCoder101.动态规划;

import java.util.Stack;

public class BM77最长的括号子串 {

    public int longestValidParentheses (String s) {
        //存储索引的栈
        Stack<Integer> stack =new Stack<>();
        int res =0;
        //匹配括号开始的位置
        int start =-1;
        for (int i = 0; i < s.length(); i++) {
            //碰到左括号直接入栈
            if (s.charAt(i)=='('){
                stack.push(i);
            }else {
                //右括号，判断栈是否为空
                if (stack.isEmpty()){
                    start =i;       //记录开始位置
                }else {
                    //栈不为空，弹出左括号
                    stack.pop();
                    if (!stack.isEmpty()){
                        //栈中还有左括号，右括号不够，减去栈顶位置就是长度
                        res =Math.max(res,i-stack.peek());
                    }else {
                        //栈为空，左右括号匹配，长度就是减去上一次结束位置
                        res =Math.max(res,i-start);
                    }
                }
            }
        }
        return res;
    }
}
