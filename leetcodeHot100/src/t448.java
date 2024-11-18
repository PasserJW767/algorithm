import java.util.*;

public class t448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        // 奇技淫巧，用数组作为hashmap
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // nums[i]获得当前位置的元素值，我们对nums[abs(nums[i])-1]做标记，标明该数字已经出现过了
            // 则在nums数组中，<0的元素都是出现过的
            if (nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        // 遍历整个数组，如果当前下标为正数，说明当前下标的这个数字从未出现过，没有被修改为负数，将这个下标加到结果中去
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers2(new int[]{4,3,2,7,8,2,3,1}));
    }
}
