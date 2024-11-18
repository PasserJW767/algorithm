public class t581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            // 如果从左到右，出现了从大到小排序的情况，right就会被更新为突变的下标i
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            // 如果从右到左，出现了从小排到大的情况，left就会被更新为突变的下标n-i-1
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1? 0: right - left + 1;
    }
    public static void main(String[] args) {

    }
}
