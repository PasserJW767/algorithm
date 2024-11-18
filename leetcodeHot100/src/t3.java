import java.util.HashMap;
import java.util.Map;

public class t3 {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口加哈希表
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for (int j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) i = Math.max(i, map.get(s.charAt(j))); // 更新左指针
            map.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 在遍历的过程中不断更新字符串长度
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
