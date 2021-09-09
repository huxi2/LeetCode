package Arrays;

import org.junit.Test;

/**
 * 买股票的最佳时机，最大利润
 */
public class MaxProfit {
    /**
     * 贪心算法:   找到上涨的这段时间使用最大值减掉最低值得到该次收益
     * 未买入时：遇到最低价就买入（下一天价格大于当前价格买入）
     * 买入后：遇到最高价就卖出（下一天价格小于当前价格卖出）
     * 1ms  99.65
     * 38mb  79.66
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)return 0;
        //price可能是0
        int buyPrice = -1, totalProfit = 0;
        int len = prices.length;
        //初始化价格
        for (int i = 0; i < len - 1; i++) {
            //未买入,后一天价格高于当前价格时，在当前买入
            if (buyPrice == -1 && prices[i + 1] > prices[i]) {
                buyPrice = prices[i];
            }
            //已买入，后一天价格小于当前价格，在当前卖出
            if (buyPrice != -1 && prices[i + 1] < prices[i]) {
                totalProfit += prices[i] - buyPrice;
                buyPrice = -1;
            }
        }
        //最后一天仍然持有股票,且价格高于购入价格时售出
        if (buyPrice != -1 && prices[len - 1] > buyPrice)
            totalProfit += prices[len - 1] - buyPrice;
        return totalProfit;
    }

    /**
     * 改进贪心： 第一种时找到一段时间内上涨。这段时间也是由每一天的上涨组合成的
     *          那么我们就可以将所有上涨的时间段换成，i+1天价格大于i天 价格的差值求和
     *          就是用i+1 减 i天得到的正数相加。负数丢掉
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2)return 0;
        //price可能是0
        int totalProfit = 0;
        int len = prices.length;
        //初始化价格
        for (int i = 1; i < len; i++) {
            totalProfit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return totalProfit;
    }

    /**
     * 使用动态规划：DP
     * 1.定义dp[i]含义。
     * 2.推理 dp[i] 和 dp[i-1]关系    满足无后效性
     * 3.初始化dp[0]
     * 4.for循环计算结果。  答案未必是dp[-1]
     * 3ms
     * 38.2M
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2)return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        //动态规划:dp[i]第i天可获得的最大利润
        //1.dp[len][2]  dp[i][0]:代表i天交易结束手里没有股票的利润，
        //              dp[i][1]:代表i天交易结束后手里有股票的利润。
        //2.dp[i][0]:交易完手里没有股票（之前就没有股票，今天不操作。  之前有股票，且今天卖出） 取二者大值
        //          dp[i][0] = max(dp[i-1][0], dp[i-1][1]+price[i])
        //  dp[i][1]:交易完手里有股票（之前没有，今天购入。    之前有，今天不操作） 二者取最大
        //          dp[i][1] = max(dp[i-1][0]-prices[i], dp[i-1][1])
        //3.初始化   dp[0][0] = 0;  dp[0][1] = -prices[0]
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            //今天结束没股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天结束有股票
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0],dp[len - 1][1]);
    }

    /**
     * 改进的动态规划：由于后一天利润仅和前一天利润相关，所以可以将dp[][2]优化成只需要两个参数，
     *              分别表示前一天的持有最高利润 holdP和未持有最高利润 unHoldP;
     *              初始化: holdP= -proces[0]  unHoldP=0;
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2)return 0;
        int len = prices.length;
        int holdP = -prices[0], unHoldP = 0;
        for (int i = 1; i < len; i++) {
            int holdPt = holdP, unHoldPt = unHoldP;
            //今天未持有： 昨天未持有今天不操作  昨天持有今天出售
            unHoldP = Math.max(unHoldPt, holdPt + prices[i]);
            //今天持有: 昨天没有今天买入  昨天持有今天不操作
            holdP =  Math.max(unHoldPt - prices[i], holdPt);
        }
        return Math.max(holdP, unHoldP);
    }

    @Test
    public void mytest() {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit3(prices));
    }
}