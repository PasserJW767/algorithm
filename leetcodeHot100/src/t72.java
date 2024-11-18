public class t72 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        // 第一行初始化
        for (int j = 1; j <= l2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列初始化
        for (int i = 1; i <= l1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i) != word2.charAt(j)) {
                    // 替换、删除、插入
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1]; // -> 这一步不用动
                }
            }
        }

        return dp[l1][l2];
    }
    public static void main(String[] args) {

    }
}
