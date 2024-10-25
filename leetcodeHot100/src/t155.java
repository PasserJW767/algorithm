import java.util.*;

public class t155 {
    static class MinStack {

        Deque<int[]> deque;

        public MinStack() {
            deque = new ArrayDeque<>();
        }

        public void push(int val) {
            if (deque.isEmpty()) {
                deque.push(new int[]{val, val});
            } else {
                int[] peek = deque.peek();
                if (peek[1] < val) {
                    deque.push(new int[]{val, peek[1]});
                } else {
                    deque.push(new int[]{val, val});
                }
            }
        }

        public void pop() {
            deque.pop();
        }

        public int top() {
            return deque.peek()[0];
        }

        public int getMin() {
            return deque.peek()[1];
        }
    }
    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
