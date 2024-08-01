package removingElements;

import java.util.Arrays;

public class t844 {
    public static String processArray(String s){
        char[] s_arr = s.toCharArray();
        int fast = 0; int slow = -1;
        int length = 0;
        boolean flag = true;
        while (fast < s_arr.length){
            if (s_arr[fast] != '#'){
                fast++;
                continue;
            }
            if (flag){
                slow = fast - 1;
            } else {
                slow++;
            }
            int count = 0;
            while (fast < s_arr.length && s_arr[fast] == '#') {
                fast++;
                count++;
            }
            while (count > 0){
                if (fast < s_arr.length){
                    s_arr[slow] = s_arr[fast];
                } else {
                    s_arr[slow] = '#';
                }
                count--;
                slow--;
                fast++;
            }
            flag = false;
        }
        while (length < s_arr.length && s_arr[length] != '#') {
            length++;
        }
        System.out.println(Arrays.copyOf(s_arr, length));
        return Arrays.toString(Arrays.copyOf(s_arr, length));
    }
    public static boolean backspaceCompare(String s, String t) {
        // 处理字符s
        s = processArray(s);
        t = processArray(t);
        if (s.length() != 0 && t.length() != 0 &&processArray(s).equals(processArray(t))){
            return true;
        } else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(backspaceCompare("a#c", "b"));
    }
}
