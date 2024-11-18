public class t461 {
    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while (result != 0){
            if ((result & 1) == 1){
                count++;
            }
            result = result >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(3, 1));
    }
}
