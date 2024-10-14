import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class t739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty() && stack.peek()[0] < temperatures[i]){ // 说明出现了下一个大温度
                while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                    Integer[] popElem = stack.pop();
                    result[popElem[1]] = i - popElem[1];
                }
            }
            stack.push(new Integer[]{temperatures[i], i});
        }
        return result;
    }
    public static int[] dailyTemperatures2(int[] temperatures) {
        Deque<Integer[]> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (!deque.isEmpty() && deque.getLast()[0] < temperatures[i]){ // 说明出现了下一个大温度
                while (!deque.isEmpty() && deque.getLast()[0] < temperatures[i]){
                    Integer[] popElem = deque.removeLast();
                    result[popElem[1]] = i - popElem[1];
                }
            }
            deque.addLast(new Integer[]{temperatures[i], i});
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{73,74,75,71,69,72,76,73})));
    }
}
