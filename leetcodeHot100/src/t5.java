public class t5 {
    public String longestPalindrome(String s) {
        // 中心扩散法，从字符串的每一个字符出发向两边扩散求最值
        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0, right = 0;
        int len = 1;
        int maxStart = 0, maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            // 这里就是判断回文字符串是从i本身开始向两边扩散
            // 还是从[left&i]向两边扩散
            // 还是从[i&right]向两边扩散
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            // 如果left == right，长度不断+2
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1; // 重置，进行下一趟遍历
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
    public static void main(String[] args) {

    }
}
