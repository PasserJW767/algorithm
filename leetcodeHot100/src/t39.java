import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 组合，回溯，剪枝
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    public void backTracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // res -> 结果集
        // path -> 当前路径
        // candidates -> 候选数字
        // target -> 目标和
        // sum -> 当前和
        // idx -> 允许选取的下标起始位置
        if (sum == target) { // 说明找到了结果
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backTracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除path的最后一个元素
        }

    }
    public static void main(String[] args) {

    }
}
