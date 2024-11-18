public class t48 {
    public void rotate(int[][] matrix) {
        // 只需要对满足以下范围的格子做操作：
        // 0 <= i < matrix.length / 2; 0 <= j < (matrix.length + 1) / 2，弄不清楚就画个4*4和5*5的格子看一下就行
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                // 四个角转
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
    public static void main(String[] args) {

    }
}
