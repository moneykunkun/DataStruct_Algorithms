package newCoder101;


import java.util.Scanner;
import java.util.Stack;

//Emacs号称神的编辑器，它自带了一个计算器。与其他计算器不同，它是基于后缀表达式的，即运算符在操作数的后面。
// 例如“2 3 +”等价于中缀表达式的“2 + 3”。
//请你实现一个后缀表达式的计算器。
public class Nc_EmacsCalculator {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String str =null;
            Stack<Integer> stack =new Stack<>();
            for (int i=0;i<n;i++){
                str =sc.next();
                char ch =str.charAt(0);
                if (!(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))){
                    //是数字，直接入栈
                    stack.add(Integer.parseInt(str));
                }else {
                    int right=stack.pop();
                    int left=stack.pop();
                    //是运算符
                    switch (ch){
                        case '+':
                            stack.add(left+right);
                            break;
                        case '-':
                            stack.add(left-right);
                            break;
                        case '*':
                            stack.add(left*right);
                            break;
                        case '/':
                            stack.add(left/right);
                            break;
                    }
                }
            }
            System.out.println(stack.peek());
        }
    }

}
