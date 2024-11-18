import java.util.ArrayList;
import java.util.List;

public class t78 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        // 对于一个数，要么选要么不选
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) { // 已经构成了子集
            ans.add(new ArrayList<>(path)); // 写入答案
            return;
        }

        // 不选nums[i]
        dfs(i + 1);

        // 选nums[i]
        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }

    public static void main(String[] args) {

    }
}
