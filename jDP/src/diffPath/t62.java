package diffPath;

public class t62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        // 初始化行
        for (int i = 1; i < n; i++){
            dp[0][i] = 1;
        }
        // 初始化列
        for (int i = 1; i < m; i++){
            dp[i][0] = 1;
        }
        // 求解dp
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        t62 t62 = new t62();
        System.out.println(t62.uniquePaths(3,7));
    }
}
