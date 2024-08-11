package differentLocationWord;

import java.util.HashMap;
import java.util.Map;

public class t242 {
    /*
    * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
    *
    * 示例 1:
        输入: s = "anagram", t = "nagaram"
        输出: true
        示例 2:

        输入: s = "rat", t = "car"
        输出: false
    *
    *
    * */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            if (sMap.getOrDefault(t.charAt(i), 0) == 0){
                return false;
            } else {
                int tNum = tMap.getOrDefault(t.charAt(i), 0);
                if (sMap.getOrDefault(t.charAt(i), 0) < tNum + 1){
                    return false;
                }
                tMap.put(t.charAt(i), tNum + 1);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
