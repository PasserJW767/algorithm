import java.util.ArrayList;
import java.util.List;

public class t46 {
    List<Integer> nums;
    List<List<Integer>> res;

    void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    void dfs(int x) {
        if (x == nums.size() - 1) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = x; i < nums.size(); i++) {
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = new ArrayList<>();
        for (int num : nums) {
            this.nums.add(num);
        }
        dfs(0);
        return res;
    }
    public static void main(String[] args) {

    }
}
