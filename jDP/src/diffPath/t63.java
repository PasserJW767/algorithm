package diffPath;

import java.util.Arrays;

public class t63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length-1] == 1) return 0;
        // 动态规划
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 初始化dp数组，如果遇到dp[x][0] == -1, 说明其右边都不可达，dp[x-n][0] = 0
        // 初始化dp数组，如果遇到dp[0][x] == -1, 说明其右边都不可达，dp[0][x-n] = 0
        boolean flag = false;
        for (int i = 0; i < obstacleGrid.length; i++){
            if (obstacleGrid[i][0] == 1) flag = true;
            if (flag) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        flag = false;
        for (int i = 0; i < obstacleGrid[0].length; i++){
            if (obstacleGrid[0][i] == 1) flag = true;
            if (flag) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        // 障碍物处赋值-1，代表不可走
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = -1;
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        // 初始化完成后，按照递推公式递推
        for (int i = 1; i < obstacleGrid.length; i++){
            for (int j = 1; j < obstacleGrid[0].length; j++){
                if (dp[i][j] == -1) continue;
                int up = 0;
                if (dp[i-1][j] != -1) up = dp[i-1][j];
                int left = 0;
                if (dp[i][j-1] != -1) left = dp[i][j-1];
                dp[i][j] = up + left;
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
    public static void main(String[] args) {
        t63 t63 = new t63();
//        t63.uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}});
        System.out.println(t63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
