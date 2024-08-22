package dailyTemperature;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class t739 {

    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 示例 1:
     *
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     *
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     *
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     *
     *
     * */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // 0存储温度，1存储数组下标
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 下面的代码简化一下
            if (!deque.isEmpty() && deque.peek()[0] < temperatures[i]){
                while (!deque.isEmpty() && deque.peek()[0] < temperatures[i]){
                    // 弹出，保存结果
                    int[] popElem = deque.pop();
                    result[popElem[1]] = i - popElem[1];
                }
            }
            deque.push(new int[]{temperatures[i], i});
//            if (deque.isEmpty() || deque.peek()[0] >= temperatures[i]){
//                deque.push(new int[]{temperatures[i], i});
//            } else { // 此时栈顶小于目前温度
//                while (deque.peek()[0] < temperatures[i]){
//                    // 弹出，保存结果
//                    int[] popElem = deque.pop();
//                    result[popElem[1]] = popElem[1] - i;
//                }
//                deque.push(new int[]{temperatures[i], i});
//            }
        }
        if (!deque.isEmpty()){
            int[] popElem = deque.pop();
            result[popElem[1]] = 0;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
//        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
//        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
    }
}
