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
    // 基于小顶堆的实现
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        /**
         * Comparator接口说明：
         * 返回负数意味着第一个参数排在前面，返回正数则第二个参数排在前面
         * 对于队列：排在前面意味着向队头靠
         * 对于堆（PriorityQueue实现）：从队头到队尾按照从按小到大排（小根堆）、从队头到队尾按照从大到小排（大根堆）
         */
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
                // 大根堆则是o2[1] - o1[1]
            }
        };
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            // 如果元素小于k个直接入队
            if (queue.size() < k){
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else { // 如果元素大于k个
                // 当且仅当大于小顶堆最小值时入队
                if (entry.getValue() > queue.peek()[1]){
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] result = new int[k];
        // 小顶堆顶部最小，前k个大元素从大到小排序，所以逆序放置
        for (int i = k - 1; i > 0; i--){
            result[i] = queue.poll()[0];
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }
}
