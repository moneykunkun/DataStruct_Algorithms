package 数据结构.栈;

public class StackTest {
    public static void main(String[] args) {
        MyStack<Integer> myStack =new MyStack<>();
        myStack.push(1);
        myStack.push(3);
        myStack.push(5);
        myStack.push(7);
        System.out.println(myStack);
        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }

    }
}
