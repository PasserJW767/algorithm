package minLengthSubArray;

import java.util.*;

public class t904 {
    /*
     * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
     *
     * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
     *
     * - 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
     *
     * - 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
     *
     * - 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
     *
     * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
     * 输入：fruits = [1,2,1]
        输出：3
        解释：可以采摘全部 3 棵树。
     *
     * 输入：fruits = [0,1,2,2]
        输出：3
        解释：可以采摘 [1,2,2] 这三棵树。
        如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
     *
     * 输入：fruits = [1,2,3,2,2]
        输出：4
        解释：可以采摘 [2,3,2,2] 这四棵树。
        如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
     *
     * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
        输出：5
        解释：可以采摘 [1,2,1,1,2] 这五棵树。
     *
     */
    // 我的方法不好的地方在于，一开始定义了slow=0，fast=1，对于fruits.length=1的这种边界情况无法很好地处理
    public static int totalFruit(int[] fruits) {
        int slow = 0, fast = 1;
        int bf_slow = -1;
        int result = Integer.MIN_VALUE;
        Map<Integer, Integer> basket = new HashMap<Integer, Integer>();
        for (; fast < fruits.length; fast++){
            if (!basket.containsKey(fruits[slow]))
                basket.put(fruits[slow], 1);
            else if (basket.containsKey(fruits[slow]) && slow != bf_slow)
                basket.put(fruits[slow], basket.get(fruits[slow]) + 1);
            if (!basket.containsKey(fruits[fast]))
                basket.put(fruits[fast], 1);
            else
                basket.put(fruits[fast], basket.get(fruits[fast]) + 1);

            while (basket.size() > 2 && slow < fast){ // 更新slow指针
                if (basket.containsKey(fruits[slow])) {
                    if (basket.get(fruits[slow]) > 1)
                        basket.put(fruits[slow], basket.get(fruits[slow]) - 1);
                    else
                        basket.remove(fruits[slow]);
                }
                slow++;
                if (!basket.containsKey(fruits[slow]))
                    basket.put(fruits[slow], 1);
            }
            bf_slow = slow;
            result = Math.max(result, (fast - slow + 1));
        }
        return result > 0 ? result:1;
    }
    // 官方题解，学习一下
    // 使用了Map.getOrDefault()函数，代码上简洁了很多
    public static int totalFruit2(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < fruits.length; right++){
            // 只需要右指针进行put，避免了左指针和右指针重复put的情况
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2){ // 更新slow指针
                cnt.put(fruits[left], cnt.getOrDefault(fruits[left], 0) - 1);
                if (cnt.get(fruits[left]) == 0)
                    cnt.remove(fruits[left]);
                left++;
            }
            ans = Math.max(ans, right-left + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,2,1}));
        System.out.println(totalFruit(new int[]{0,1,2,2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
