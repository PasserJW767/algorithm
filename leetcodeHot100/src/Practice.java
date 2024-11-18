import java.sql.PreparedStatement;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    static int target;
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void dfs(int[] nums, int n) {
        if (n > target){
            return;
        }
        if (target == n){
            res.add(path);
        }

        for (int i = 0; i < nums.length; i++) {
            n += nums[i];
            path.add(nums[i]);
            dfs(nums, n);
            n -= nums[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = new int[]{};
        int t = 5; // 目标整数
        target = t;

        dfs(candidates, 0);

    }
}
