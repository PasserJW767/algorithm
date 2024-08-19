package implementQueuesAndStacks;

import java.util.Deque;
import java.util.LinkedList;

public class t225 {
    /*
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

        实现 MyStack 类：

        void push(int x) 将元素 x 压入栈顶。
        int pop() 移除并返回栈顶元素。
        int top() 返回栈顶元素。
        boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     *
     * 输入：
        ["MyStack", "push", "push", "top", "pop", "empty"]
        [[], [1], [2], [], [], []]
        输出：
        [null, null, null, 2, 2, false]

        解释：
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False
     *
     */
    static class MyStack {

        Deque<Integer> deque;

        public MyStack() {
            this.deque = new LinkedList<>();
        }

        public void push(int x) {
            deque.push(x);
        }

        public int pop() {
            return deque.pop();
        }

        public int top() {
            return deque.peek();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }
}
