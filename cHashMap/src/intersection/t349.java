package intersection;

import java.util.*;
import java.util.stream.IntStream;

public class t349 {
    /*
    * 给定两个数组 nums1 和 nums2 ，返回它们的交集。输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序。
    *
    * 示例 1：
        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2]
        示例 2：

        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]
        解释：[4,9] 也是可通过的
    *
    * */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] result = new int[Math.max(nums1.length, nums2.length)];
        int count = 0;
        for (int i : nums2) {
            if (map.getOrDefault(i, 0) > 0) {
                result[count] = i;
                count++;
                map.put(i, 0);
            }
        }
        return IntStream.range(0, count)
                .map(n -> result[n])
                .toArray();
    }
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
