package addOfFourNums;

import java.util.HashMap;
import java.util.Map;

public class t454 {
    /*
    * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
        0 <= i, j, k, l < n
        nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
    *
    * 示例 1：
        输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
        输出：2
        解释：
        两个元组如下：
        1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
        2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

        示例 2：
        输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
        输出：1
    *
    * */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (map.containsKey(0 - (nums3[i] + nums4[j]))){
                    count += map.get(0 - (nums3[i] + nums4[j]));
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2},new int[]{0,2}));
        System.out.println(fourSumCount(new int[]{0},new int[]{0},new int[]{0},new int[]{0}));
    }
}
