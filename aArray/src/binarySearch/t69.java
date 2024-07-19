package binarySearch;

import java.util.Arrays;

public class t69 {
    /*
    * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
    * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
    * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
    * */
    public static int mySqrt(int x) {
        // 二分搜索解
        if (x == 0 || x == 1){
            return x;
        }
        int ans = x;
        int left = 0;
        int right = x;
        while (left <= right){
            int middle = (left + right) / 2;
            if ((long) middle * middle <= x){
                ans = middle;
                left = middle + 1;
            } else{
                right = middle - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(4)); // Output: 2
        System.out.println(mySqrt(8)); // Output: 2, 8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
    }
}
