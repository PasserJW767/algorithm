package findStr;

public class t28 {
    /*
    *
    *
    *
    * */
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                int k = i + 1;
                int l = 1;
                boolean returnFlag = true;
                while (k < haystack.length() && l < needle.length()){
                    boolean b = (haystack.charAt(k) != needle.charAt(l));
                    if (b) {
                        returnFlag = false;
                        break;
                    }
                    k++;
                    l++;
                }
                // 如果遍历的长度==目标字符串的长度的话，可以返回下标，否则说明无法达到目标字符串的长度，e.g ("aaa", "aaaa")
                if (returnFlag && k - i == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("aaa", "aaaa"));
    }
}
