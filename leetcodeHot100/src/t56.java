import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p,q) -> p[0] - q[0]); // 数组按照左端点进行排序
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // 可以合并
                ans.get(m-1)[1] = Math.max(ans.get(m-1)[1], p[1]); // 更新右端点最大值
            } else { // 不相交，无法合并
                ans.add(p); // 新的合并区间
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {

    }
}
