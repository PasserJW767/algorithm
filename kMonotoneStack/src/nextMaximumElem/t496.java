package nextMaximumElem;

import java.util.*;

import static java.lang.Integer.MIN_VALUE;

public class t496 {
    /**
     * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
     * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
     * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
     *
     * 示例 1：
     * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出：[-1,3,-1]
     * 解释：nums1 中每个值的下一个更大元素如下所述：
     * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
     * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
     * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
     *
     * 示例 2：
     * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出：[3,-1]
     * 解释：nums1 中每个值的下一个更大元素如下所述：
     * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
     * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
     *
     * */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 用Hash建立映射，存储<value, index in nums1>
        Map<Integer, Integer> map = new HashMap<>();
        // 结果数组
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
            result[i] = -1;
        }
        // 用单调栈解决此问题
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            // 说明找到了一个大元素，判断栈里面的内容在不在map中
            if (!deque.isEmpty() && nums2[i] > deque.peek()){
                while (!deque.isEmpty() && nums2[i] > deque.peek()){
                    // 如果这个元素在数组中则赋值
                    if (map.containsKey(deque.peek())){
                        result[map.get(deque.peek())] = nums2[i];
                    }
                    deque.pop();
                }
            }
            deque.push(nums2[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2,1,3}, new int[]{2,3,1})));
    }
}
