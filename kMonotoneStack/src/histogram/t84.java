package histogram;

import java.util.Stack;

public class t84 {
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 示例1：
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     * 解释：最大的矩形为图中红色区域，面积为 10
     *
     * 示例2：
     * 输入： heights = [2,4]
     * 输出： 4
     *
     */
    public static int largestRectangleArea(int[] heights) {
        // 卡神单调栈版
        // 思路：找每个柱子左边比他矮的、右边比他矮的，然后用底乘以柱子高度就是一块的面积
        int result = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素
        // 之所以要头部+0，是因为如果遇到了类似于[8,6,2,4]这种单调递减的数组，在6的时候就要进入while循环的计算逻辑，在循环中需要6、8以及8前面的一个元素，但是这时候栈为空就会有问题
        // 之所以要末尾+0，是因为如果遇到了类似于[2,4,6,8]这种单调递增的数组，我们就无法进入下面的while循环中的计算逻辑
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;

        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[stack.peek()] < heights[i]){ // 如果栈顶对应值 小于 遍历对应值，则压入栈中
                stack.push(i);
            } else if (heights[stack.peek()] == heights[i]) { // 如果栈顶对应值 等于 当前遍历的对应值
                // 不影响结果，只是思路不同
                stack.pop();
                stack.push(i);
            } else { // 栈顶对应值 大于 遍历对应值，求面积
                // 实际上重点考虑的就是当前遍历到的元素、栈顶元素、栈顶后一个元素
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    // 栈顶元素
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        // 栈顶后一个元素
                        int left = stack.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = heights[mid];
                        result = Math.max(result, w * h);
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[]{2,4}));
    }
}
