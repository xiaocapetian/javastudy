package leetcode100;

public class l123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        //bp[i] 第i天
        //dp[i][0]//代表不操作  [的最赚状态]
        //dp[i][1]//代表不第一次持有
        //dp[i][2]//代表第一次不持有
        //dp[i][3]//代表第2次持有
        //dp[i][4]//代表第2次不持有

        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        dp[0][3]=-prices[0];
        dp[0][4]=0;
        //if(prices.length==1)return 0;
        for (int i = 1; i < prices.length; i++) {
            //不操作
            dp[i][0]=dp[i-1][0];
            //代表第一次持有
            dp[i][1]=Math.max(dp[i-1][1],//可能1,之前就持有,没卖
                    -prices[i]);//可能2,之前就不持有,今天买了
            //代表第一次不持有
            dp[i][2]=Math.max(dp[i-1][2],//可能1,之前就卖了第一次持有的,现在不持有,也不买
                    dp[i-1][1]+prices[i]);//可能2,之前持有,今天卖了
            //代表第2次持有
            dp[i][3]=Math.max(dp[i-1][3],//可能1,之前就持有,没卖
                    dp[i-1][2]-prices[i]);//可能2,之前就不持有,今天买了
            //代表第2次不持有
            dp[i][4]=Math.max(dp[i-1][4],//可能1,之前就不持有,也不买
                    dp[i-1][3]+prices[i]);//可能2,之前持有,今天卖了
        }
        //return Math.max(Math.max(dp[prices.length-1][0],dp[prices.length-1][2]),dp[prices.length-1][4]);
        return dp[prices.length-1][4];
    }
}
