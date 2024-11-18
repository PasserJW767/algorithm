import java.util.ArrayList;
import java.util.List;

public class t438 {
    public static List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口解法
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int l = 0, r = 0;
        for (; r < s.length(); r++) {
            cnt[s.charAt(r) - 'a']--;
            // >0，窗口内的情况：p中存在的字母在s中还没出现
            // =0，窗口内的情况：p中存在的字母在s中出现了，导致数量被减为了0；或者字母不存在于p中
            // <0，窗口内的情况：p中存在的字母在s中已经多次出现了，可以进行窗口收缩；或者出现了不必要的字母，此时也可以进行窗口的收缩
            while (cnt[s.charAt(r) - 'a'] < 0){
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            // 检查窗口长度，若满足要求，则将结果放入result
            if (r - l + 1 == p.length()) {
                result.add(l);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }
}
