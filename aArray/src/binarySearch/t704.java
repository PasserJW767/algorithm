package binarySearch;

public class t704 {
    /*
    * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
    * */
    public static int search(int[] nums, int target) {
        int rv = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] == target){
                rv = middle;
                break;
            }
            else if (nums[middle] < target){
                left = middle + 1;
                continue;
            }
            else{ // nums[middle] > target
                right = middle - 1;
                continue;
            }
        }
        return rv;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9)); // Output: 4, 9 出现在 nums 中并且下标为 4
//        int[] nums = {-1,0,3,5,9,12};
//        System.out.println(search(nums, 2)); // Output: -1, 2 不存在 nums 中因此返回 -1
    }
}
