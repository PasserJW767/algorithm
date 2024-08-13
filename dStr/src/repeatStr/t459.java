package repeatStr;

public class t459 {
    /*
    * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    * 示例 1:
        输入: s = "abab"
        输出: true
        解释: 可由子串 "ab" 重复两次构成。
        示例 2:
        输入: s = "aba"
        输出: false
        示例 3:
        输入: s = "abcabcabcabc"
        输出: true
        解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
    *
    * */
    public static boolean repeatedSubstringPattern_mine(String s) {
        if (s.length() == 1) return false;
        int slow = 0;
        int fast = 1;
        int subLength = 0;
        while (fast < s.length()){
            if (s.charAt(slow) == s.charAt(fast)){
                if (fast - slow > subLength){
                    subLength = fast - slow;
                }
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        slow = 0; fast = subLength;
        while (slow < s.length() && fast < s.length()){
            if (fast > s.length() - 1 || s.charAt(slow) != s.charAt(fast)){
                return false;
            }
            slow++;
            fast++;
        }
        if (fast - subLength < subLength){
            return false;
        }
        return true;
    }
    public static int[] buildNext(String s){
        int[] next = new int[s.length()];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < s.length(); i++){
            while (j >= 0 && next[i] != next[j + 1]){
                j = next[j];
            }
            if (next[i] == next[j+1]){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public static boolean repeatedSubstringPattern(String s){
        int[] next = buildNext(s);
        int len = s.length();
        if (next[len - 1] != -1 && len % (len - (next[len-1]+1)) == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabc"));
        System.out.println(repeatedSubstringPattern("ababba"));
        System.out.println(repeatedSubstringPattern("abaababaab"));
        System.out.println(repeatedSubstringPattern("aabaaba"));
    }
}
