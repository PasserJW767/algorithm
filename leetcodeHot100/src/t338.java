import java.util.ArrayList;
import java.util.Arrays;

public class t338 {
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0){
                count += tmp & 1;
                tmp = tmp >> 1;
            }
            result[i] = count;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
