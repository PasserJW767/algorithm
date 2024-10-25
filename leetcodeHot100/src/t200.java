public class t200 {
    public static int numsIslands(char[][] grid){
        // 动态规划求解
        int[][] dp = new int[grid.length][grid[0].length];
        // 初始化
        int currNo = 0;
        for (int j = 0; j < grid[0].length; j++){
            if (grid[0][j] == '1'){
                if (j > 0){
                    // 判断左边的情况
                    if (dp[0][j - 1] != 0){
                        dp[0][j] = dp[0][j-1];
                    } else {
                        dp[0][j] = ++currNo;
                    }
                } else { // j == 0
                    dp[0][j] = ++currNo;
                }
            }
        }
        for (int i = 1; i < grid.length; i++){
            if (grid[i][0] == '1'){
                if (dp[i - 1][0] != 0){
                    dp[i][0] = dp[i - 1][0];
                } else {
                    dp[i][0] = ++currNo;
                }
            }
        }

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                // 开始求解动态规划数组
                if (i > 0 && j > 0 && grid[i][j] == '1'){
                    if (dp[i - 1][j] == 0 && dp[i][j - 1] == 0){
                        dp[i][j] = ++currNo;
                    } else if (dp[i - 1][j] == 0 || dp[i][j - 1] == 0){
                        // 如果两个有一个为0，则取不为0的那个
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    } else if (dp[i - 1][j] != 0 && dp[i][j - 1] != 0){
                        // 两个都不为0
                        // 若两个值相等，随便等一个就行了
                        if (dp[i - 1][j] == dp[i][j - 1]){
                            dp[i][j] = dp[i - 1][j];
                        } else {
                            // 两个值不相等，当前岛屿可以把两座岛屿连接起来，取最小值，curNo - 1
                            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                            // 让岛屿号相等
                            dp[i - 1][j] = dp[i][j];
                            dp[i][j - 1] = dp[i][j];
                            currNo -= 1;
                        }
                    }
                } else { // i == 0 / j == 0的情况
                    if (i == 0 && j == 0){
                        continue;
                    }
                    if (i == 0){
                        if (grid[i][j-1] == '1' && grid[i][j] == '1' && dp[i][j-1] != dp[i][j]){
                            dp[i][j] = dp[i][j-1];
                        }
                    } else { // j == 0
                        if (grid[i-1][j] == '1' && grid[i][j] == '1' && dp[i-1][j] != dp[i][j]){
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return currNo;
    }
    public static void dfs(char[][] grid, int i, int j){

        // 终止条件，当遍历的位置超过网格边界的时候，return
        if (!inArea(grid, i, j)) return;
        if (grid[i][j] != '1') return;

        grid[i][j] = '2'; // 标记已遍历
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
    public static boolean inArea(char[][]grid, int i, int j){
        if (0 <= i && i < grid.length &&
            0 <= j && j < grid[0].length) return true;
        else return false;
    }
    public static int numsIslandsCorrect(char[][] grid){
        // 用DFS~~~~~~~~~~~~~~~
        if (grid == null || grid.length == 0) return 0;

        int nums = 0; // 岛屿数量初始化为0
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    ++nums;
                    dfs(grid, i, j);
                }
            }
        }

        return nums;
    }
    public static void print(char[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        char[][] grid2 = {{'1'},{'1'}};
        char[][] grid3 = {{'1','1','1','1','1','0','1','1','1','1'},
                          {'1','0','1','0','1','1','1','1','1','1'},
                          {'0','1','1','1','0','1','1','1','1','1'},
                          {'1','1','0','1','1','0','0','0','0','1'},
                          {'1','0','1','0','1','0','0','1','0','1'},
                          {'1','0','0','1','1','1','0','1','0','0'},
                          {'0','0','1','0','0','1','1','1','1','0'},
                          {'1','0','1','1','1','0','0','1','1','1'},
                          {'1','1','1','1','1','1','1','1','0','1'},
                          {'1','0','1','1','1','1','1','1','1','0'}};
        System.out.println(numsIslandsCorrect(grid3));
    }
}
