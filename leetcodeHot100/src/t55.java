public class t55 {
    public boolean canJump(int[] nums) {
        int k = 0; // 目前格子能跳到的最远距离
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false; // 如果格子已经超过了能跳的最远距离，那就返回false
            k = Math.max(k, i + nums[i]); // 更新“最远距离”
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
