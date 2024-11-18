import java.util.Arrays;

public class t322 {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        // 贪心 -> 不可行，因为最优解未必通过贪心结果组成。如果贪心最大面值的硬币，结果可能是由部分小硬币组成的（因为大硬币无法组成目标面额）
        int[] dp = new int[amount + 1]; // 动态规划数组表示组成目标金额需要几枚硬币
        // 初始化dp数组
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // 如果组成金额0需要0枚硬币
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) { // 每个面额下的硬币
                if (coin <= i){ // 如果硬币面额 < 当前所需组成的amount
                    // 要么使用coin：此时硬币数量=1+(目标amount-指定面额)硬币数量
                    // 要么不用coin：此时硬币数量=目标amount硬币数量
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1,2,5}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }
}
