public class t494 {
    public static int findTargetSumWays(int[] nums, int target){
        // 二维数组求解
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 条件1：如果数组所有元素的和无法超过target，没有解
        // 条件2：如果target+sum的和无法整出2，说明无法分出均匀的两个子集以达到目标，没有解
        if (Math.abs(target) > sum || (target + sum) % 2 == 1) return 0;
        int bagSize = (target + sum) / 2;

        // 初始化动态数组
        // i是物品索引，j是背包容量大小
        int[][] dp = new int[nums.length][bagSize + 1];

        // 对dp数组进行初始化
        if (nums[0] <= bagSize) dp[0][nums[0]] = 1; // 初始化第一行
        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { // 如果当前物品大小为0
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);
        }

        // 求解dp数组
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums[i] > j){ // 如果物品大小大于背包容量的话，就不用这个物品
                    dp[i][j] = dp[i - 1][j];
                } else { // 否则，解法数量=放/不放这个物品的总和. 第一项是放这个物品，第二项是不放这个物品
                    dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][bagSize];

    }
    public static void main(String[] args) {
//        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1}, 1));
    }
}
