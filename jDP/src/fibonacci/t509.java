package fibonacci;

public class t509 {
    /**
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给定 n ，请计算 F(n) 。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     * 示例 3：
     *
     * 输入：n = 4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     * */
    public int fib(int n) {
        // 建立对应大小的数组，初始值默认为0
        int[] arr = new int[n+1];
        if (n == 0) return 0;
        else if (n == 1) return 1;
        // 给对应的位置赋初始值
        arr[1] = 1;
        for (int i = 2; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
    // 优化版本，不需要记录整个序列，只需要维护两个值
    public int fib_update(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        // 建立对应大小的数组，初始值默认为0
        int[] arr = new int[2];
        // 给对应的位置赋初始值
        arr[0] = 0;
        arr[1] = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++){
            fibN = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = fibN;
        }
        return fibN;
    }
    public static void main(String[] args) {
        t509 t509 = new t509();
        System.out.println(t509.fib_update(2));
        System.out.println(t509.fib_update(3));
        System.out.println(t509.fib_update(4));
        System.out.println(t509.fib_update(5));
    }
}
