public class t121 {
    public static int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0; // 成本初始化为正无穷，利润初始化为0
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
