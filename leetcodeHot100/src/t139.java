import java.util.ArrayList;
import java.util.List;

public class t139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]表示从[0~i]可以被wordDict中的内容表示
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 表示空字符串可以被wordDict表示
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                // 0~i可被wordDict中的元素表示 && 后面也能被wordDict表示的话
                if (dp[i] && wordDict.contains(s.substring(i, j))){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak("applepenapple", wordDict));

    }
}
