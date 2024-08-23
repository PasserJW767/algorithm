package receiveRainwater;

import java.util.Stack;

public class t42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 示例1：
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     *
     * 示例 2：
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *
     * */
    public static int trap(int[] height) {
        // 根据卡神单调栈版写的
        int size = height.length;
        if (size <= 2) return 0; // 接不到雨水直接return

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            int stackTop = stack.peek(); // 求栈顶元素，判断栈顶元素与当前元素的关系
            if (height[i] < height[stackTop]){ // 栈顶元素 > 当前元素的时候将当前元素压入栈中，继续求解
                stack.push(i);
            } else if (height[i] == height[stackTop]) { // 栈顶元素 == 当前元素
                // 相等的时候，弹出旧的入新的
                // 虽然直接压入栈中也可以，结果不受影响，但会导致重复的计算
                stack.pop();
                stack.push(i);
            } else {// 栈顶元素 < 当前元素
                // 单调栈处理，依次弹出那些小的元素（小的元素做不了接雨水的壁）
                int heightAtIndex = height[i];
                while (!stack.isEmpty() && heightAtIndex > height[stackTop]){
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();
                        int h = Math.min(height[left], heightAtIndex) - height[mid];
                        int w = i - left - 1;
                        sum += h * w;
                        stackTop = stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}
