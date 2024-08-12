package ransomNote;

import java.util.HashMap;
import java.util.Map;

public class t383 {
    /*
    * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
        如果可以，返回 true ；否则返回 false 。
        magazine 中的每个字符只能在 ransomNote 中使用一次。
    *
    * 示例 1：
        输入：ransomNote = "a", magazine = "b"
        输出：false
        示例 2：
        输入：ransomNote = "aa", magazine = "ab"
        输出：false
        示例 3：
        输入：ransomNote = "aa", magazine = "aab"
        输出：true
    *
    * */
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++){
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) - 1);
            if (map.get(ransomNote.charAt(i)) < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
