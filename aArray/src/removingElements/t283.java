package removingElements;

import java.util.Arrays;

public class t283 {
    /*
    * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    * */
    public static void moveZeroes1(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            // 快指针++的两种可能
            // 1. 快指针比慢指针要慢，快指针必须追上慢指针
            // 2. 快指针要找到!=0的数，方便和慢指针进行交换
            while ((fast < nums.length && nums[fast] == 0) || fast < slow)
                fast++;
            // 慢指针++的可能：慢指针要找到!=0的数，方便和快指针进行交换
            while (slow < nums.length && nums[slow] != 0)
                slow++;
            // 如果没有超出边界，就进行交换
            if (fast < nums.length && slow < nums.length && slow < fast){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
                fast++;
            }
        }
    }
    public void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }
    public static void main(String[] args) {
        moveZeroes1(new int[]{0,1,0,3,12}); // [1, 3, 12, 0, 0]
//        moveZeroes(new int[]{0}); // [0]
//        moveZeroes(new int[]{1,0}); // [1, 0]
//        moveZeroes(new int[]{1,0,1}); // [1, 1, 0]
    }
}
