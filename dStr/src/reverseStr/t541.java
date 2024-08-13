package reverseStr;

import java.util.Arrays;

public class t541 {
    /*
    * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
        如果剩余字符少于 k 个，则将剩余字符全部反转。
        如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
    * 示例 1：
        输入：s = "abcdefg", k = 2
        输出："bacdfeg"
        示例 2：
        输入：s = "abcd", k = 2
        输出："bacd"
    *
    * */
    public static String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();
        int count = 0;
        int left = 0, right = 0;
        for (int i = 0; i < ca.length; i++){
            count++;
            // 每2k就反转前k个
            // 如果字符数 >= k && < 2k则转前k个
            if ((i + 1 <= ca.length && count == 2*k) || (i + 1 == ca.length && count >= k && count < 2*k)){
                right = left + k - 1;
                int tm = left + 2*k;
                while (left < right && left < ca.length && right < ca.length){
                    char tmp = ca[left];
                    ca[left] = ca[right];
                    ca[right] = tmp;
                    left++;
                    right--;
                }
                left = tm;
                count = 0;
            } else if (i + 1 == ca.length && count < k){ // 如果字符数<k，全部反转
                right = ca.length - 1;
                while (left < right){
                    char tmp = ca[left];
                    ca[left] = ca[right];
                    ca[right] = tmp;
                    left++;
                    right--;
                }
            }
        }
        return String.valueOf(ca);
    }
    public static void main(String[] args) {
//        System.out.println(reverseStr("abcdefg", 2));
//        System.out.println(reverseStr("abcd", 2));
//        System.out.println(reverseStr("abcd", 4));
        System.out.println(reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
    }
}
