package prevK;

import java.util.*;

public class t347 {
    /*
    * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    *
    * 示例 1:

        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:

        输入: nums = [1], k = 1
        输出: [1]
    *
    * */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        // 替换map1的value和key
        for (Integer i : map1.keySet()) {
            // 从map1中查询value -> times
            int times = map1.get(i);
            // 从map2中获得列表
            List<Integer> lists = map2.getOrDefault(times, new LinkedList<>());
            lists.add(i);
            map2.put(times, lists);
        }
        int[] result = new int[k];
        // 将所有key放入列表里，逆序排序（从大到小）
        List<Integer> keySet = new LinkedList<>();
        for (Integer i : map2.keySet()) {
            keySet.add(i);
        }
        Collections.sort(keySet, Comparator.reverseOrder());
        int index = 0;
        for (Integer i : keySet) {
            List<Integer> integers = map2.get(i);
            for (Integer integer : integers) {
                result[index] = integer;
                index++;
                k--;
                if (k == 0) return result;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }
}
