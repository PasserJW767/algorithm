import java.util.Random;

public class t215 {
    public static int findKthLargest(int[] nums, int k) {
        int last_max = Integer.MIN_VALUE;
        int count = 1;
        for (int num : nums) {
            if (num == last_max){
                count += 1;
                continue;
            }
            last_max = Math.max(last_max, num);
            count = 1;
        }
        if (count >= k) return last_max;
        int current_max = Integer.MIN_VALUE;
        while (count <= k){
            int tmpCount = 1;
            current_max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num < last_max && num >= current_max){
                    if (num == current_max){
                        tmpCount++;
                        continue;
                    }
                    current_max = num;
                    tmpCount = 1;
                }
            }
            last_max = current_max;
            k -= tmpCount;
            count++;
        }
        return current_max;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public int quickSort(int[] nums, int left, int right, int k){
        if (nums.length == 1) return nums[0];
        // 选定pivot
        int randomIndex = left + new Random().nextInt(right - left + 1);
        // 交换nums[pivot]和nums[right]
        swap(nums, randomIndex, right);

        // 进行快排的操作
        int storeIndex = left;
        for (int i = storeIndex; i <= right; i++){
            if (nums[i] < nums[right]){
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        // 交换回来
        swap(nums, right, storeIndex);

        // 如果不是第k大，继续递归
        if (storeIndex < k){
            return quickSort(nums, storeIndex + 1, right, k);
        } else if (storeIndex > k){
            return quickSort(nums, left, storeIndex - 1, k);
        } else {
            return nums[storeIndex];
        }
    }
    public int quickSortFast(int[] nums, int left, int right, int k){
        // 让最左侧数字作为pivot
        int partition = nums[left];

        // 定义变量用于双路快排
        int l = left + 1, r = right;
        // 进行快排的操作
        while (true) {
            while (l <= r && nums[l] < partition) l++;
            while (r >= l && nums[r] > partition) r--;
            if (l > r) break;
            swap(nums, l, r);
            l++;
            r--;
        }

        // 交换回来
        swap(nums, left, r);

        // 如果不是第k大，继续递归
        if (r < k){
            return quickSortFast(nums, r + 1, right, k);
        } else if (r > k){
            return quickSortFast(nums, left, r - 1, k);
        } else {
            return partition;
        }
    }
    public int findKthLargestCorrect(int[] nums, int k) {
        // 基于快排来做
        /**
         * 快排思想：
         * 1. 选择一个随机置作为pivot
         * 2. 以这个pivot为边界，区分出左和右
         * 3. 判断pivot是否是第k大的，如果不是第k大的，根据当前所处的位置index，判断往左边找还是往右边找
         * 4. 循环以上思路得到最后结果
         * */
        // 最后输入nums.length - k，是因为实际上上面是求从小->大第k个元素
        // 要求第k大的元素，实际上就是从小->大第nums.length - k个元素
        return quickSortFast(nums, 0, nums.length - 1, nums.length - k);
    }
    public static void main(String[] args) {
        t215 t215 = new t215();
        System.out.println(t215.findKthLargestCorrect(new int[]{3,2,1,5,6,4}, 2));
//        System.out.println(t215.findKthLargestCorrect(new int[]{3,2,3,1,2,4,5,5,6}, 4));
//        System.out.println(findKthLargest(new int[]{2,1}, 1));
    }
}
