package 数据结构.栈.leetcode;

import java.util.Stack;

public class Lc232_MyQueue {

    /**
     * 双栈实现队列
     * 整体思路：
     * 入队操作直接入第一个栈
     * 出队操作，当第二个栈不为空，直接弹出第二个栈的元素，
     * 第二个栈为空的情况下，将第一个栈的元素出栈，入第二个栈，继续弹出
     */
    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int x) {
            //直接入第一个栈
            stack1.push(x);
        }

        public int pop() {
            //出栈操作，先判断队列是否为空
            if (empty()) {
                return -1;
            }
            //整个队列不为空，先判断栈2是否为空
            if (this.stack2.empty()) {
                while (!this.stack1.empty()) {
                    int pop = this.stack1.pop();
                    this.stack2.push(pop);
                }
            }
            return this.stack2.pop();
        }

        public int peek() {
            //出栈操作，先判断队列是否为空
            if (empty()) {
                return -1;
            }
            //整个队列不为空，先判断栈2是否为空
            if (this.stack2.empty()) {
                while (!this.stack1.empty()) {
                    int pop = this.stack1.pop();
                    this.stack2.push(pop);
                }
            }
            return this.stack2.peek();
        }

        public boolean empty() {
            //两个栈都为空的情况下，队列为空，返回true
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return true;
            }
            return false;
        }
    }
}
