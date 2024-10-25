import java.util.Arrays;

public class t322 {
    public static int coinChange(int[] coins, int amount) {
        // 贪心
        // 排序
        int count = 0;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        return amount == 0 ? count:-1;
    }
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }
}
