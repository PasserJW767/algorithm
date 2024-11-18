import java.util.Arrays;
import java.util.Properties;

public class t416 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false; // 和无法评分，则无法分成两个相等的子集

        int bagSize = sum / 2; // 目标和的结果

        // 动态数组定义与初始化
        int[][] dp = new int[nums.length][bagSize + 1];
        if (nums[0] <= bagSize) dp[0][nums[0]] = 1;
        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                numZeros++;
//            }
//            dp[i][0] = (int) Math.pow(2, numZeros);
            dp[i][0] = 0;
        }

        // 填充动态数组
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (nums[i] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        return dp[nums.length - 1][bagSize] == bagSize;
    }
    public static void main(String[] args) {
//        System.out.println(canPartition(new int[]{1,5,11,5}));
//        System.out.println(canPartition(new int[]{1,2,3,5}));
//        System.out.println(canPartition(new int[]{1,2,5}));
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
}
