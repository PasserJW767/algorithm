package binarySearch;

public class t367 {
    /*
    * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
    * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
    * 不能使用任何内置的库函数，如  sqrt 。
    * */
    public static boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right){
            int middle = (left + right) / 2;
            if ((long) middle * middle < num){
                left = middle + 1;
            }
            else if ((long) middle * middle > num){
                right = middle - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16)); // Output: true, 因为 4 * 4 = 16 且 4 是一个整数。
        System.out.println(isPerfectSquare(14)); // Output: false, 因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
    }
}
