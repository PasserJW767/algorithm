package removingElements;

import java.util.Arrays;

public class t977 {
    /*
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     */
    public static int[] sortedSquares1(int[] nums) {
        int i = nums.length - 1;
        while (i > 0){
            if (Math.abs(nums[i]) < Math.abs(nums[0])){
                int temp = nums[i];
                nums[i] = nums[0] * nums[0];
                nums[0] = temp;
            } else {
                nums[i] = nums[i] * nums[i];
            }
            i--;
        }
        nums[0] = nums[0] * nums[0];
        return nums;
    }
    // 类似于归并排序的思路
    // 因为全为负数的数组是一个有序数组，全为正数的数组是一个有序数组，两个有序数组可以使用归并排序
    // 只需要拓宽额外的空间复杂度
    public static int[] sortedSquares2(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;){
            if (nums[i] * nums[i] > nums[j] * nums[j]){
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares1(new int[]{-4,-1,0,3,10}))); // [0,1,9,16,100]
        System.out.println(Arrays.toString(sortedSquares1(new int[]{-5,-3,-2,-1}))); // fail case - [1,4,9,25]
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-4,-1,0,3,10}))); // [0,1,9,16,100]
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-5,-3,-2,-1}))); // fail case - [1,4,9,25]
    }
}
