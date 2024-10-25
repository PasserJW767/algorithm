import java.util.Arrays;

public class t238 {
    // 超出内存限制 - 上下三角数组
    public static int[] productExceptSelfTriangle(int[] nums) {
        // 先尝试使用上下三角矩阵求解
        int[][] arr = new int[nums.length][nums.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++){
                if (i == j){
                    arr[i][j] = 1;
                } else if (j == 0) {
                    arr[i][j] = nums[j];
                } else {
                    arr[i][j] = nums[j] * arr[i][j - 1];
                }
            }
        }
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (i != j - 1 || i == 0){
                    arr[i][j] = arr[i][j - 1] * nums[j];
                } else {
                    arr[i][j] = arr[i][j - 2] * nums[j];
                }
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++){
            result[i] = arr[i][nums.length - 1];
        }
        result[nums.length - 1] = arr[nums.length - 1][nums.length - 2];
        return result;
    }
    public static int[] productExceptSelf(int[] nums){
        int[] results = new int[nums.length];
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            results[i] *= tmp;
        }
        return results;
    }
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[]{1, 2, 3, 4});
//        int[] result = productExceptSelf(new int[]{2, 3, 5, 0});
        System.out.println(Arrays.toString(result));
    }
}
