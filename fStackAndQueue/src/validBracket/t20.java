package validBracket;

import java.util.Deque;
import java.util.LinkedList;

public class t20 {
    /*
    * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。
    *
    * 示例 1：

        输入：s = "()"
        输出：true
        示例 2：

        输入：s = "()[]{}"
        输出：true
        示例 3：

        输入：s = "(]"
        输出：false
    *
    * */
    public static boolean isValid(String s) {
        char[] strArray = s.toCharArray();
        if (strArray.length % 2 != 0){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : strArray) {
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char popElement = stack.pop();
                if (
                        (popElement == '(' && c == ')') ||
                        (popElement == '{' && c == '}') ||
                        (popElement == '[' && c == ']')
                ) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("){"));
    }
}
