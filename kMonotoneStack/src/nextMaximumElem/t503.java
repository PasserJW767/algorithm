package nextMaximumElem;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class t503 {
    /**
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
     *
     * 示例 1:
     * 输入: nums = [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     *
     * 示例 2:
     * 输入: nums = [1,2,3,4,3]
     * 输出: [2,3,4,-1,4]
     *
     * */
    public static int[] nextGreaterElements(int[] nums) {
        // 常规思路是将数组复制一遍求值，但也可以通过遍历数组两次的形式来实现(通过求余)
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        // 定义单调栈
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < nums.length * 2; i++) {
            if (!deque.isEmpty() && deque.peek()[0] < nums[i % nums.length]){
                // 满足情况，弹出，并给结果数组赋值
                while (!deque.isEmpty() && deque.peek()[0] < nums[i % nums.length]){
                    int[] popElem = deque.pop();
                    result[popElem[1]] = nums[i % nums.length];
                }
            }
            deque.push(new int[]{nums[i % nums.length], i % nums.length});
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}
