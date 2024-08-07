package spiralMatrix;

import java.util.Arrays;

public class t59 {
    /*
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * 示例1：
        输入：n = 3
        输出：[[1,2,3],[8,9,4],[7,6,5]]
     *
     * 示例 2：
        输入：n = 1
        输出：[[1]]
     *
     */
    public static int[][] generateMatrix(int n) {
        int startx = 0, starty = 0;
        int i, j;
        int count = 1;
        int offset = 0;
        int[][] nums = new int[n][n];
        int loop = 1;
        while (loop <= n / 2){
            i = startx;
            j = starty;
            for ( ; j < n - 1 - offset; j++){
                nums[startx][j] = count++;
            }
            for ( ; i < n - 1 - offset; i++){
                nums[i][j] = count++;
            }
            for ( ; j > starty; j--){
                nums[i][j] = count++;
            }
            for ( ; i > startx; i--){
                nums[i][starty] = count++;
            }
            offset++;
            startx++;
            starty++;
            loop++;
        }
        if (n % 2 != 0){
            nums[startx][starty] = count++;
        }
        return nums;
    }
    public static void main(String[] args) {
//        int[][] result = generateMatrix(1);
        int[][] result = generateMatrix(2);
//        int[][] result = generateMatrix(3);
//        int[][] result = generateMatrix(4);
//        int[][] result = generateMatrix(5);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%3d ", result[i][j]); // 使用固定宽度打印数字
            }
            System.out.println();
        }
    }
}
