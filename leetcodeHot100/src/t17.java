import java.util.ArrayList;
import java.util.List;

public class t17 {

    // Mapping集合
    private static final String[] MAPPING = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    // 结果
    private final List<String> res = new ArrayList<>();
    // 输入digits
    private char[] digits;
    // 当前结果paths
    private char[] paths;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return List.of();
        }
        // 初始化
        this.digits = digits.toCharArray();
        // 从0开始
        paths = new char[n];
        dfs(0);
        return res;
    }

    private void dfs(int i) {
        // 长度到了，保存结果并return
        if (i == digits.length) {
            res.add(new String(paths));
            return ;
        }
        // 遍历每一种可能的字符，不断地递归
        for (char c : MAPPING[digits[i] - '0'].toCharArray()) {
            paths[i] = c;
            dfs(i + 1);
        }
    }
    public static void main(String[] args) {

    }
}
