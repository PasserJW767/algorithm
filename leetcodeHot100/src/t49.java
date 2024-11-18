import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class t49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // https://zhuanlan.zhihu.com/p/656502312 -> 一文掌握Java8 Stream 中 Collectors 的24个操作
        // https://blog.csdn.net/veezean/article/details/125720283 ->  全面吃透JAVA Stream流操作，让代码更加的优雅
        return new ArrayList<>(Arrays.stream(strs).collect(
                Collectors.groupingBy(str -> {
                    int[] counter = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        counter[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < counter.length; i++) {
                        if (counter[i] != 0) {
                            sb.append((char) ('a' + i));
                            sb.append(counter[i]);
                        }
                    }
                    return sb.toString();
                })
        ).values());
    }
    public static void main(String[] args) {

    }
}
