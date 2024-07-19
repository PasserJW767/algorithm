package binarySearch;

public class t35 {
    /*
    * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    * 请必须使用时间复杂度为 O(log n) 的算法。
    * */
    public static int searchInsert(int[] nums, int target) {
        int rv = -1;
        int left = 0;
        int right = nums.length - 1;
        int middle = -1000;
        while (left <= right){
            middle = (left + right) / 2;
            if (nums[middle] == target){
                return middle;
            }
            else if (nums[middle] < target){
                left = middle + 1;
            }
            else if (nums[middle] > target){
                right = middle - 1;
            }
        }
        if (middle == left){ // target < nums[middle], 插入在middle前
            return middle;
        }
        else if (middle == right){ // target > nums[middle], 插入在middle后
            return left;
        }
        return rv;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5)); // Output: 2
        System.out.println(searchInsert(nums, 2)); // Output: 1
//        int[] nums = {1,3,5,6};
//        System.out.println(searchInsert(nums, 7)); // Output: 4
    }
}
