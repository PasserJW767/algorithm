package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class t54 {
    /*
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * 示例1：
        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]
     *
     * 示例2：
        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int startx = 0, starty = 0;
        int i, j;
        int offset = 0;
        int mRows = matrix.length;
        int mCols = matrix[0].length;
        int beforex = -1, beforey = -1;
        if (mRows == 0 && mCols == 0){
            result.add(matrix[0][0]);
            return result;
        }
        boolean totalFlag = false;
        while (starty <= (mCols / 2) && startx <= (mRows / 2)){
            totalFlag = true;
            i = startx;
            j = starty;
            if (startx == beforex || starty == beforey) break;
            boolean jflag = true, iflag = true;
            for ( ; j < mCols - 1 - offset; j++) {
                result.add(matrix[startx][j]);
                jflag = false;
                totalFlag = false;
            }
            beforey = j;
            for ( ; i < mRows - 1 - offset; i++){
                result.add(matrix[i][j]);
                iflag = false;
                totalFlag = false;
            }
            beforex = i;
            for ( ; j > starty; j--) {
                result.add(matrix[i][j]);
                totalFlag = false;
                if (iflag) break;
            }
            for ( ; i > startx; i--){
                result.add(matrix[i][starty]);
                totalFlag = false;
                if (jflag) break;
            }
            startx++;
            starty++;
            offset++;
        }
        if (mCols % 2 != 0 && mRows % 2 != 0 && (totalFlag || (startx + 1 < mRows && starty + 1 < mCols))){
            result.add(matrix[--startx][--starty]);
        }
        return result;
    }
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int mRows = matrix.length;
        int mCols = matrix[0].length;
        int[][] visited = new int[mRows][mCols];

        int startx = 0, starty = 0;
        int offset = 0;
        int i, j;
        while (starty <= (mCols / 2) && startx <= (mRows / 2)){
            i = startx;
            j = starty;
            for ( ; j < mCols - 1 - offset; j++){
                if (visited[startx][j] == 0){
                    visited[startx][j] = 1;
                    result.add(matrix[startx][j]);
                }
            }
            for ( ; i < mRows - 1 - offset; i++){
                if (visited[i][j] == 0){
                    visited[i][j] = 1;
                    result.add(matrix[i][j]);
                }
            }
            for ( ; j > starty; j--){
                if (visited[i][j] == 0){
                    visited[i][j] = 1;
                    result.add(matrix[i][j]);
                }
            }
            for ( ; i > startx; i--){
                if (visited[i][starty] == 0){
                    visited[i][starty] = 1;
                    result.add(matrix[i][starty]);
                }
            }
            startx++;
            starty++;
            offset++;
        }
        if (mRows % 2 != 0 || mCols % 2 != 0){
            if (startx - 1 < mRows && starty - 1 < mCols){
                if (visited[startx - 1][starty - 1] == 0){
                    result.add(matrix[startx - 1][starty - 1]);
                }
            }

        }
        return result;
    }
    // 机智的官方题解
    public static List<Integer> spiralOrder3(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom){
            // 这些条件需要考虑清楚，为什么是等于
            // 上面两个需要包含=号是为了避免那种单独一个的情况
            // 单独一个的时候left=right, top=bottom，会导致上面两个for循环失效，无法精准地踩到对应的数字
            for (int column = left; column <= right; column++){
                result.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++){
                result.add(matrix[row][right]);
            }
            // 为了避免那种只有一行/一列，构不成“口”的形状，那种一行的只需要完成上面那两个for循环的遍历就好了！！！
            if (left < right && top < bottom){
                for (int column = right - 1; column > left; column--){
                    result.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--){
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
    public static void main(String[] args) {
//        System.out.println(spiralOrder2(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}));
//        System.out.println(spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}}));
//        System.out.println(spiralOrder(new int[][]{{3},{2}}));
//        System.out.println(spiralOrder(new int[][]{{6,9,7}}));
//        System.out.println(spiralOrder(new int[][]{{6},{9},{7}}));
//        System.out.println(spiralOrder(new int[][]{{2,5,8},{4,0,-1}}));
//        System.out.println(spiralOrder(new int[][]{{1,2,3,4,5,6,7,8,9,10}}));
        System.out.println(spiralOrder2(new int[][]{{1}}));
//        System.out.println(spiralOrder(new int[][]{{2,3,4}, {5,6,7}, {8,9,10}, {11,12,13}, {14,15,16}}));
//        System.out.println(spiralOrder(new int[][]{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}}));
    }
}
