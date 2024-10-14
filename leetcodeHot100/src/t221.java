public class t221 {
    public static int maximalSquare(char[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1'){
                    result = Math.max(result, 1);
                    int offset = 1;
                    boolean flag = false;
                    boolean enterFlag = false;
                    while (i + offset < matrix.length && j + offset < matrix[0].length){
                        enterFlag = true;
                        for (int k = i; k <= i + offset; k++){
                            for (int l = j; l <= j + offset; l++){
                                if (matrix[k][l] != '1') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag){
                                break;
                            }
                        }
                        if (flag){
                            break;
                        }
                        if (!flag && enterFlag){
                            result = Math.max(result, (offset + 1) * (offset + 1));
                        }
                        offset++;
                    }
                }
            }
        }
        return result;
    }
    public static int maximalSquareDp(char[][] matrix) {
        // 动态数组初始化
        int maxSide = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] != '0') {
                dp[i][0] = 1;
                maxSide = 1;
            }
        }
        for (int j = 0; j < matrix[0].length; j++){
            if (matrix[0][j] != '0') {
                dp[0][j] = 1;
                maxSide = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
    public static void main(String[] args) {
//        int result = maximalSquareDp(new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}});
        int result2 = maximalSquareDp(new char[][]{{'0', '1'}, {'1', '0'}});
        System.out.println(result2);
    }
}
