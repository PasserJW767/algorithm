public class t279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // dp数组中的每个下标i表示，组成值i完全平方数的最少数量
        // 填充dp数组
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是，该数由许多1组成，实际上这里设置成Integer.MAX_VALUE也可以
            for (int j = 1; i - j * j >= 0; j++){
                // 首先说明for循环的条件为什么是: i-j*j>=0，首先变换一下i>=j*j
                // j*j实际上就凑成了一个“完全平方数”，在这个for循环里，j的值从1开始，每次不断+1，那么j*j的值就是1,4,9,16...，每次都是完全平方数
                // 这里实际上就是“假设我们使用这个完全平方数”时
                // i-j*j中，我们想求i需要多少个完全平方数凑成
                // 也就是使用了这个完全平方数后的数（j*j是完全平方数，i-j*j是剩余的数值），剩余的数值最少需要由几个完全平方数凑成
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {

    }
}
