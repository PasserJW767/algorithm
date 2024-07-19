package binarySearch;

import java.util.Arrays;

public class t34 {
    /*
    * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
    * 如果数组中不存在目标值 target，返回 [-1, -1]。
    * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
    * */
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        // 思路是用二分法找到比target小的位置，以及比target大的位置
        // 先找小的位置
        int min_idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] >= target)
                right = middle - 1;
            else if (nums[middle] < target)
                left = middle + 1;
        }
        if (left <= nums.length - 1 && nums[left] == target)
            min_idx = left;
        else
            min_idx = -1;

        // 再找大的位置
        int max_idx = -1;
        left = 0;
        right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] <= target)
                left = middle + 1;
            else if (nums[middle] > target)
                right = middle - 1;
        }
        if (right >= 0 && nums[right] == target)
            max_idx = right;
        else
            max_idx = -1;
        return new int[]{min_idx, max_idx};
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8))); // Output: [3,4]
//        int[] nums = {5,7,7,8,8,10};
//        System.out.println(Arrays.toString(searchRange(nums, 6))); // Output: [-1,-1]
//        int[] nums = {5,7,7,8,8,10};
//        System.out.println(Arrays.toString(searchRange(nums, 0))); // Output: [-1,-1]
    }
}
