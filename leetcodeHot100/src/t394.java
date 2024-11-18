import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class t394 {
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;

        // 两个辅助栈，一个存数字，一个存字符串
        Deque<Integer> stack_multi = new ArrayDeque<>();
        Deque<String> stack_res = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '['){ // 如果等于左括号，将res和multi入栈中
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') { // 如果等于右括号，当前结果=last_res+last_multi*res
                Integer last_multi = stack_multi.pop();
                String last_res = stack_res.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < last_multi; i++) tmp.append(res);
                res = new StringBuilder(last_res + tmp);
            }
            else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }

        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
