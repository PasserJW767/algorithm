package minLengthSubArray;

public class t209 {
    /*
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其总和大于等于 target 的长度最小的子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * 示例 1：
        输入：target = 7, nums = [2,3,1,2,4,3]
        输出：2
        解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
        输入：target = 4, nums = [1,4,4]
        输出：1
     * 示例 3：
        输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        输出：0
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int slow = 0, fast = 0;
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        boolean flag = true;
        boolean return_flag = false;
        while (true){
            if (flag) sum += nums[fast];
            int temp = fast;
            int temp2 = slow;
            if (sum >= target){
                if ((fast - slow) < min_len){
                    min_len = fast - slow + 1;
                }
                sum -= nums[slow];
                slow++;
//                if (fast < nums.length - 1) fast++;
            } else if (sum < target){
                if (fast < nums.length - 1) fast++;
            }
            flag = temp != fast;
            if (fast == temp && slow == temp2){
                if (fast < nums.length - 1) fast++;
                if (slow < nums.length - 1) slow++;
            }
            if (fast >= nums.length - 1 && slow >= nums.length - 1) {
                if (return_flag){
                    break;
                } else {
                    return_flag = true;
                }
            }
        }
        return min_len > nums.length ? 0:min_len;
    }
    // 滑动窗口
    public static int minSubArrayLen2(int target, int[] nums) {
        int result = Integer.MAX_VALUE; // 返回结果
        int slow = 0; // 慢指针
        int sum = 0;
        for (int fast = 0; fast < nums.length; fast++){
            // 如果sum < target，不断加上对应的值
            sum += nums[fast];
            // 如果sum >= target，就更新slow的位置，直到sum < target，继续更新fast
            while (sum >= target){
                if (result > (fast - slow + 1))
                    result = fast - slow + 1;
                sum -= nums[slow];
                slow++;
            }
        }
        return result > nums.length? 0:result;
    }
    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(7, new int[]{2,3,1,2,4,3})); // 2
        System.out.println(minSubArrayLen(4, new int[]{1,4,4})); // 1
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // 0
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5})); // 3
        System.out.println(minSubArrayLen2(7, new int[]{1,1,1,1,7})); // 1
    }
}
