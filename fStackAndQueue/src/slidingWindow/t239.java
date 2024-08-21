package slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class t239 {
    /*
    * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
        返回 滑动窗口中的最大值 。
    *
    * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        输出：[3,3,5,5,6,7]
        解释：
        滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7
    *
    * 输入：nums = [1], k = 1
        输出：[1]
    *
    * */
    // 自定义一个队列
    static class MyQueue{
        Deque<Integer> deque = new LinkedList<>();

        // 弹出方法, 若当前要弹出的数值等于队列出口（最大值）则弹出
        void poll(int val){
            if (!deque.isEmpty() && deque.getFirst() == val){
                deque.pollFirst();
            }
        }

        // 添加方法，若是前面有比自己小的元素，全部弹出
        void add(int val){
            while (!deque.isEmpty() && deque.getLast() < val){
                deque.pollLast();
            }
            deque.addLast(val);
        }

        // 获得最大值方法
        int getMaxValue(){
            return deque.getFirst();
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1){
            return nums;
        }
        // 结果数组存放元素个数为nums.length-k+1
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        // 自定义队列
        MyQueue queue = new MyQueue();
        // 将前k元素放入队列
        for (int i = 0; i < k; i++){
            queue.add(nums[i]);
        }
        res[num++] = queue.getMaxValue();
        for (int i = k; i < nums.length; i++){
            // 滑动窗口移除最前面的元素
            queue.poll(nums[i - k]);
            // 滑动窗口压入最后面的元素
            queue.add(nums[i]);
            // 获得最大值
            res[num++] = queue.getMaxValue();
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
    }
}
