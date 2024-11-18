public class t75 {
    public void sortColors(int[] nums) {
        int n0 = 0, n1 = 0;
        // 双指针解法
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; //
            nums[i] = 2; // 遍历到的位置直接赋成2

            // 如果遍历到的这一位，值是小于2的（==1 / ==0）则执行下面的操作
            if (num < 2){ // 为1相当于用1覆盖掉第n1位
                nums[n1++] = 1;
            }
            if (num < 1){ // 为0相当于用0覆盖掉第n0位
                nums[n0++] = 0;
            }
        }
    }
    public static void main(String[] args) {

    }
}
