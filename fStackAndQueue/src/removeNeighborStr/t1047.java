package removeNeighborStr;

import java.util.Deque;
import java.util.LinkedList;

public class t1047 {
    /*
    * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
        在 S 上反复执行重复项删除操作，直到无法继续删除。
        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
    *
    * 示例：
        输入："abbaca"
        输出："ca"
        解释：
        例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
    *
    * */

    public static String removeDuplicates(String s) {
        // 思路是两个串来回倒腾删除
        Deque<Character> stack1 = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            stack1.push(c);
        }
        Deque<Character> fullStack = stack1;
        Deque<Character> emptyStack = stack2;
        while (reverseStack(fullStack, emptyStack)){
            if (fullStack == stack1 && emptyStack == stack2){
                fullStack = stack2;
                emptyStack = stack1;
            } else {
                fullStack = stack1;
                emptyStack = stack2;
            }
        }
        StringBuilder result = new StringBuilder();
        if (stack1.isEmpty()){
            // 操作stack2
            while (!stack2.isEmpty()){
                result.append(stack2.pop());
            }
        } else {
            // 操作stack1
            while (!stack1.isEmpty()){
                result.append(stack1.pop());
            }
            result = result.reverse();
        }
        return result.toString();
    }
    public static boolean reverseStack(Deque<Character> fullStack, Deque<Character> emptyStack){
        char previous = ' ';
        boolean deleteFlag = false;
        while (!fullStack.isEmpty()){
            if (previous != ' ' && previous == fullStack.peek()){
                deleteFlag = true;
                fullStack.pop();
                emptyStack.pop();
                previous = ' ';
                // 不加下面这个while会超时，因为可能有很多次不必要的倒腾
                while (!emptyStack.isEmpty() && !fullStack.isEmpty() && emptyStack.peek() == fullStack.peek()){
                    emptyStack.pop();
                    fullStack.pop();
                }
            } else {
                char fullChar = fullStack.pop();
                emptyStack.push(fullChar);
                previous = fullChar;
            }
        }
        return deleteFlag;
    }
    // 别人的解法O(n)复杂度，如下。我的解法O(n^2)复杂度……小丑竟是我自己
    public static String removeDuplicates2(String s){
        // 学习了，非常精简的思路，O(n)的复杂度
        // 概括为：如果遇到相等的就回退，不相等的就替换字符
        char[] charArray = s.toCharArray();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (top == -1 || charArray[top] != charArray[i]) {
                charArray[++top] = charArray[i];
            } else {
                top--;
            }
        }
        return String.valueOf(charArray, 0, top + 1);
    }
    // 使用栈来做，这种方法对于我来说可能更好理解~
    public static String removeDuplicates3(String s){
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : charArray){
            if (stack.isEmpty() || c != stack.peek()){ // 当栈为空 || 当前字母和栈顶元素不同时
                stack.push(c);
            } else { // 当前字母和栈顶元素相同
                stack.pop(); // 弹出
            }
        }
        stack = stack.reversed();
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates3("abbaca"));
        System.out.println(removeDuplicates3("azxxzy"));
    }
}
