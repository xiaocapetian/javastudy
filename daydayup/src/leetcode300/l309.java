package leetcode300;

public class l309 {
    public int maxProfit(int[] prices) {
/*关键是你怎么想到拆成这4个状态*/
        //dp[i][0] 买入股票的状态
        //dp[i][1] 保持卖出股票的状态
        //dp[i][2] 卖出股票的状态
        //dp[i][3] 冷静期
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //dp[i][0] 持有股票的状态
            //又分这一天买入股票
            //和这一天继续持有股票
            dp[i][0] = Math.max(
                    Math.max(dp[i-1][3]-prices[i],dp[i-1][1]-prices[i]),
                    dp[i-1][0]);
            //dp[i][1] 保持卖出股票的状态
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]);
            //dp[i][2] 卖出股票的状态
            dp[i][2] = dp[i-1][0]+prices[i];
            //dp[i][3] 冷静期
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(Math.max(dp[prices.length-1][1],dp[prices.length-1][2]),dp[prices.length-1][3]);
    }
}
