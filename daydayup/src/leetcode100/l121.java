package leetcode100;

public class l121 {
    //这题老子就没看懂,只能买一次,,只有一次机会!!!
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //bp[0]代表持有[的最赚状态], bp[1]代表不持有[的最赚状态]
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        //if(prices.length==1)return 0;
        for (int i = 1; i < prices.length; i++) {
            //持有
            dp[i][0]=Math.max(dp[i-1][0],//可能1,之前就持有,没卖
                    -prices[i]);//可能2,之前就不持有,今天买了
            /*为什么不是dp[i-1][1]-prices[i],因为tm只能买一次,今天买了说明之前就没买过!*/
            //不持有
            dp[i][1]=Math.max(dp[i-1][1],//可能1,之前就不持有,也不买
                    dp[i-1][0]+prices[i]);//可能2,之前持有,今天卖了
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
