public class Main {
    public static int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            System.out.println("start-------fastIndex=" + fastIndex);
            if (nums[fastIndex] != nums[slowIndex]){
                nums[++slowIndex] = nums[fastIndex];
            }
            System.out.println("end-------fastIndex=" + fastIndex);
        }
        return ++slowIndex;
    }
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//        int[] arr = {1, 1, 2};
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(arr.length);
        System.out.println(removeDuplicates(arr));
    }
}