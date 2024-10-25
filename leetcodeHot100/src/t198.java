public class t198 {
    public static int rob(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        else if (nums.length == 1){
            return nums[0];
        }
        else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        // 初始化dp
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(dp[1], dp[0] + nums[2]);
        if (nums.length == 3){
            return dp[2];
        }
        int cur_max = dp[2];
        // 正式对dp做操作
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
            if (dp[i] > cur_max){
                cur_max = dp[i];
            }
        }
        return cur_max;
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

    }
}
