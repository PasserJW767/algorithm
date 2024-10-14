package climbStairs;

public class t70 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     * */
    // 递推方法数量
    // 初始化dp[0]=0,dp[1]=1,dp[2]=2
    // dp[i] = dp[i-1] + dp[i-2]
    // 补充解释一下，为什么后面的数量可以由前面两次推导出来呢？
    // 因为一次只可以走1步/2步，实际上我们就是根据走到n-1和n-2的方法数，分别再走1步/2步到达当前的n阶
    public int climbStairs(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        // 建立对应大小的数组，初始值默认为0
        int[] arr = new int[2];
        // 给对应的位置赋初始值
        arr[0] = 1;
        arr[1] = 2;
        int num = 0;
        for (int i = 3; i <= n; i++){
            num = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = num;
        }
        return num;
    }
    public static void main(String[] args) {
        t70 t70 = new t70();
        System.out.println(t70.climbStairs(2));
        System.out.println(t70.climbStairs(3));
        System.out.println(t70.climbStairs(4));
        System.out.println(t70.climbStairs(5));
    }
}
