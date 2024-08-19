package implementQueuesAndStacks;

import java.util.Deque;
import java.util.LinkedList;

public class t232 {
    /*
    * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

        实现 MyQueue 类：

        void push(int x) 将元素 x 推到队列的末尾
        int pop() 从队列的开头移除并返回元素
        int peek() 返回队列开头的元素
        boolean empty() 如果队列为空，返回 true ；否则，返回 false
        说明：

        你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
        你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
    *
    * 示例 1：
        输入：
        ["MyQueue", "push", "push", "peek", "pop", "empty"]
        [[], [1], [2], [], [], []]
        输出：
        [null, null, null, 1, 1, false]

        解释：
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    *
    * */
    static class MyQueue {

        Deque<Integer> inDeque;
        Deque<Integer> outDeque;
        int len;

        public MyQueue() {
            this.inDeque = new LinkedList<>();
            this.outDeque = new LinkedList<>();
            this.len = 0;
        }

        public void push(int x) {
            this.inDeque.push(x);
            this.len++;
        }

        public int pop() {
            if (this.len == 0){
                return -1;
            }
            while (!inDeque.isEmpty()){
                outDeque.push(inDeque.pop());
            }
            int result = outDeque.pop();
            while (!outDeque.isEmpty()){
                inDeque.push(outDeque.pop());
            }
            this.len--;
            return result;
        }

        // 官方解：如果outDeque不为空，从outDeque中pop，当outDeque为空时，再将inDeque的内容pop出去
        public int pop2() {
            // 若outDeque为空，倒数据
            if (outDeque.isEmpty()){
                in2out();
            }
            // 若outDeque不为空，弹出outDeque的第一个
            return outDeque.pop();
        }

        public int peek() {
            if (this.len == 0){
                return -1;
            }
            while (!inDeque.isEmpty()){
                outDeque.push(inDeque.pop());
            }
            int result = outDeque.peek();
            while (!outDeque.isEmpty()){
                inDeque.push(outDeque.pop());
            }
            return result;
        }

        // 官方解：如果outDeque不为空，从outDeque中pop，当outDeque为空时，再将inDeque的内容peek出去
        public int peek2(){
            // 若outDeque为空，倒数据
            if (outDeque.isEmpty()){
                in2out();
            }
            // 若outDeque不为空，弹出outDeque的第一个
            return outDeque.peek();
        }

        // 官方定义的方法，将inDeque的元素放入到outDeque，因为是公共方法所以拿出来了
        private void in2out(){
            while (!inDeque.isEmpty()){
                outDeque.push(inDeque.pop());
            }
        }

        public boolean empty() {
            if (this.len != 0){
                return false;
            } else {
                return true;
            }
        }

        // 官方实现，不需要len
        public boolean empty2(){
            return inDeque.isEmpty() && outDeque.isEmpty();
        }
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.empty());
        System.out.println(myQueue.peek());
    }
}
