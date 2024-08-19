package removingElements;

public class t27 {
    /*
    * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
    * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
    * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
    * 返回 k。
    * */

    // 我的快慢指针写法
    public static int removeElement1(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex){
            // 找左边 == val的元素
            while (leftIndex <= rightIndex && nums[leftIndex] != val)
                ++leftIndex;
            // 找右边 != val的元素
            while (leftIndex <= rightIndex && nums[rightIndex] == val)
                --rightIndex;
            // 左边 == val和右边 != val 交换
            if (leftIndex < rightIndex){
                nums[leftIndex++] = nums[rightIndex--];
            }
        }
        return leftIndex;
    }
    // 快慢指针标准写法
    public static int removeElement2(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if (nums[fastIndex] != val){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
    // 双向指针（头尾指针）写法
    public static int removeElement3(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex){
            // 找左边 == val的元素
            while (leftIndex <= rightIndex && nums[leftIndex] != val)
                ++leftIndex;
            // 找右边 != val的元素
            while (leftIndex <= rightIndex && nums[rightIndex] == val)
                --rightIndex;
            // 左边 == val和右边 != val 交换
            if (leftIndex < rightIndex){
                nums[leftIndex++] = nums[rightIndex--];
            }
        }
        return leftIndex;
    }
    // 快慢指针（再写一次）
    public static int removeElement4(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
    public static void main(String[] args) {
        System.out.println(removeElement1(new int[]{3,2,2,3}, 3)); // Output: 2
        System.out.println(removeElement1(new int[]{0,1,2,2,3,0,4,2}, 2)); // Output: 5
        System.out.println(removeElement2(new int[]{3,2,2,3}, 3)); // Output: 2
        System.out.println(removeElement2(new int[]{0,1,2,2,3,0,4,2}, 2)); // Output: 5
        System.out.println(removeElement3(new int[]{3,2,2,3}, 3)); // Output: 2
        System.out.println(removeElement3(new int[]{0,1,2,2,3,0,4,2}, 2)); // Output: 5
        System.out.println(removeElement4(new int[]{3,2,2,3}, 3)); // Output: 2
        System.out.println(removeElement4(new int[]{0,1,2,2,3,0,4,2}, 2)); // Output: 5
    }
}
