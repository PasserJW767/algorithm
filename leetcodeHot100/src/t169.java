import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class t169 {
    public static int majorityElementHash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer i : map.keySet()) {
            System.out.println(map.get(i));
            if (map.get(i) > nums.length / 2){
                return i;
            }
        }
        return 0;
    }
    public static void swap (int[] nums, int idx1, int idx2){
        if (idx1 == idx2) return;
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
    public static void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int pivot = nums[left];
        int idx = left + 1;
        for (int i = left + 1; i < right; i++){
            if (nums[i] < pivot){
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, left, idx - 1);
        quickSort(nums, left, idx - 1);
        quickSort(nums, idx, right);
    }
    public static int majorityElementQuickSort(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums[nums.length / 2];
    }
    public static void main(String[] args) {
//        System.out.println(majorityElementHash(new int[]{3,2,3}));
        System.out.println(majorityElementQuickSort(new int[]{3,2,3}));
    }
}
