import java.util.Arrays;
import java.util.Map;

public class t152 {
    public static int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max[i] = nums[i];
            min[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min((nums[i]), max[i - 1] * nums[i]));
        }
        int ans = max[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
//        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
//        System.out.println(maxProduct(new int[]{0, 2}));
//        System.out.println(maxProduct(new int[]{3,-1,4}));
        System.out.println(maxProduct(new int[]{-2,3,-4}));
    }
}
