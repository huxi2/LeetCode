package dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;           //未持有利润
        dp[0][1] = -prices[0];  //持有（购入）
        for (int i = 1; i < prices.length; i++) {
            //今天未持有总利润= max(前一天未持有,前一天已经持有再今天卖出)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有 = max(昨天持有，昨天未持有今天购入)
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
