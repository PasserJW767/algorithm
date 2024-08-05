package removingElements;

import java.util.Arrays;

public class t844 {
    /*
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * 示例 1：
        输入：s = "ab#c", t = "ad#c"
        输出：true
        解释：s 和 t 都会变成 "ac"。
     * 示例 2：
        输入：s = "ab##", t = "c#d#"
        输出：true
        解释：s 和 t 都会变成 ""。
     * 示例 3：
        输入：s = "a#c", t = "b"
        输出：false
        解释：s 会变成 "c"，但 t 仍然是 "b"。
     */
    /*
     * 这题我没解出来，但是下面是一个很好的解题思路
     * 大概就是定义快慢指针，如果!='#'的话做赋值操作，快慢指针同时++（相当于确认一个字符的存在）
     * 如果遇到了'#'，快指针走过，慢指针回退（相当于删掉一个字符）
     */
    public static boolean backspaceCompare(String s, String t){
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        return stringHelper(ss).equals(stringHelper(tt));
    }
    public static String stringHelper(char[] arr){
        int slow = 0, fast = 0;
        while (fast < arr.length){
            if (arr[fast] != '#'){
                arr[slow++] = arr[fast++];
            } else {
                fast++;
                if (slow > 0) slow--;
            }
        }
        return new String(arr).substring(0,slow);
    }
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));
    }
}
