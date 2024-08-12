package sumOfThreeNums;

import java.util.*;
import java.util.stream.Stream;

public class t15 {
    /*
    * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
    *
    * 示例 1：
        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
        解释：
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        注意，输出的顺序和三元组的顺序并不重要。
        示例 2：
        输入：nums = [0,1,1]
        输出：[]
        解释：唯一可能的三元组和不为 0 。
        示例 3：
        输入：nums = [0,0,0]
        输出：[[0,0,0]]
        解释：唯一可能的三元组和为 0 。
    *
    * */
    // 用Hash，O(n^2)超时
    public static List<List<Integer>> threeSum_hash(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                int key = 0 - (nums[i] + nums[j]);
                // 如果满足条件
                if (map.containsKey(key)){
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(0 - (nums[i] + nums[j]));
                    // 排序一下，如果可以索引到，就不加入列表，不能索引到就加入（但是排序理论上最差O(n^2)）
                    t = t.stream().sorted().toList();
                    if (list.indexOf(t) == -1){
                        list.add(t);
                    }
                }
            }
        }
        return list;
    }
    // 双指针
    // 仍然超时了，不知道是不是因为使用了list.contains()？
    public static List<List<Integer>> threeSum_mineFunc(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // 数组排序
        // 将nums化成流，排序，转回数组
        nums = Arrays.stream(nums).sorted().toArray();
        if (nums[0] > 0) return list;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0){
                if (nums[i] == nums[i-1]){
                    continue;
                }
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if ((nums[i] + nums[left] + nums[right]) > 0){
                    right--;
                } else if ((nums[i] + nums[left] + nums[right]) < 0){
                    left++;
                } else {
                    // 可以进行存储了，但是要注意去重
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[left]);
                    t.add(nums[right]);
                    // 排序一下，如果可以索引到，就不加入列表，不能索引到就加入（但是排序理论上最差O(n^2)）
                    t = t.stream().sorted().toList();
                    if (!list.contains(t)){
                        list.add(t);
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
    // 双指针
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // 数组排序
        Arrays.sort(nums);
        if (nums[0] > 0) return list;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if ((nums[i] + nums[left] + nums[right]) > 0){
                    right--;
                } else if ((nums[i] + nums[left] + nums[right]) < 0){
                    left++;
                } else {
                    // 可以进行存储了，但是要注意去重
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[left]);
                    t.add(nums[right]);
                    list.add(t);
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
