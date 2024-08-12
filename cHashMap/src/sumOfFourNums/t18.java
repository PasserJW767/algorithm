package sumOfFourNums;

import java.util.*;

public class t18 {
    /*
    * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
        0 <= a, b, c, d < n
        a、b、c 和 d 互不相同
        nums[a] + nums[b] + nums[c] + nums[d] == target
        你可以按 任意顺序 返回答案 。
    * 示例 1：
        输入：nums = [1,0,-1,0,-2,2], target = 0
        输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        示例 2：
        输入：nums = [2,2,2,2,2], target = 8
        输出：[[2,2,2,2]]
    *
    * */
    public static List<List<Integer>> fourSum_mine(int[] nums, int target) {
        // 先做排序
        Arrays.sort(nums);
        Map<Long, List<List<Integer>>> map = new HashMap<>();
        // 先求两个数的和，Key-a+b，Value-满足这种和的可能排列组合的数组下标
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<List<Integer>> list = map.getOrDefault((long)nums[i] + nums[j], new ArrayList<List<Integer>>());
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                list.add(tmp);
                map.put((long)(nums[i] + nums[j]), list);
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        // 看c+d
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 如果有(a+b) = target - (c+d)，就尝试去记录这个结果
                if (map.containsKey((long)target - nums[i] - nums[j])){
                    List<List<Integer>> abList = map.get((long)target - nums[i] - nums[j]);
                    for (List<Integer> integers : abList) {
                        boolean flag = true; // 如果a/b的index == i/j，就不满足要求，直接break
                        for (Integer integer : integers) {
                            if (i == integer || j == integer){
                                flag = false;
                                break;
                            }
                        }
                        if (flag){
                            // 满足要求，把结果填进去
                            List<Integer> r = new ArrayList<>();
                            r.add(nums[integers.get(0)]);
                            r.add(nums[integers.get(1)]);
                            r.add(nums[i]);
                            r.add(nums[j]);
                            // 四个数排序一下，如果不在结果集里则添加到结果集里
                            r = r.stream().sorted().toList();
                            if (!result.contains(r)){
                                result.add(r);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    // Carl的解法
    public static List<List<Integer>> fourSum(int[] nums, int target) {

    }
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
//        System.out.println(1000000000+1000000000+1000000000+1000000000);
    }
}
