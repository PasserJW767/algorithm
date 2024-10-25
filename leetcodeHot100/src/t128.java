import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class t128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (!set.contains(i-1)){
                int cur_count = 1;
                while (set.contains(i+1)){
                    cur_count++;
                    i++;
                }
                max = Math.max(cur_count, max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
