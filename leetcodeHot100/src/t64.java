public class t64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i - 1 >= 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else if (j - 1 >= 0) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
    public static void main(String[] args) {

    }
}
