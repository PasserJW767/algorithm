package spiralMatrix;

import java.util.Arrays;

public class LCR146 {
    /*
     * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
        螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
     *
     * 示例1：
     * 输入：array = [[1,2,3],[8,9,4],[7,6,5]]
        输出：[1,2,3,4,5,6,7,8,9]
     *
     * 示例2：
     * 输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
        输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
     *
     */
    public static int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return new int[]{};
        }
        int aRows = array.length, aCols = array[0].length;
        int[] result = new int[aRows * aCols];
        int count = 0;
        int left = 0, right = aCols - 1, top = 0, bottom = aRows - 1;

        while (left <= right && top <= bottom){
            for (int col = left; col <= right; col++){
                result[count++] = array[top][col];
            }
            for (int row = top + 1; row <= bottom; row++){
                result[count++] = array[row][right];
            }
            if (left < right && top < bottom){
                for (int col = right - 1; col > left; col--){
                    result[count++] = array[bottom][col];
                }
                for (int row = bottom; row > top; row--){
                    result[count++] = array[row][left];
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
        System.out.println(Arrays.toString(spiralArray(new int[][]{{2,3}})));
    }
}
