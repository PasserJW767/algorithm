public class t240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true; // ==的情况
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = 0;
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j + 1] < target){
                j++;
            } else if (matrix[i][j + 1] > target && matrix[i + 1][j] < target) {
                i++;
                continue;
            } else if (matrix[i][j + 1] > target && matrix[i + 1][j] > target) {
                i++;
                j = 0;
            }
            if (j == matrix[0].length) {
                i++;
                j = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
