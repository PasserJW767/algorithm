import java.util.ArrayList;
import java.util.List;

public class t22 {
    private int n; // 括号对数，也就是左括号的最大个数
    private final List<String> ans = new ArrayList<>();
    private char[] path;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2];
        dfs(0,0);
        return ans;
    }

    // i 表示目前一共填的括号数（左+右）
    // open = 左括号个数；i-open = 右括号个数
    private void dfs(int i, int open) {
        if (i == n * 2) {
            // 左右括号防止完毕，记录答案
            ans.add(new String(path));
            return ;
        }
        if (open < n){ // 当前还可以放左括号
            path[i] = '(';
            dfs(i + 1, open + 1); // 总括号数量+1，左括号数量+1
        }
        if (i - open < open){ // 如果左括号放不了就该放右括号了
            path[i] = ')';
            dfs(i + 1, open);
        }
    }
    public static void main(String[] args) {

    }
}
