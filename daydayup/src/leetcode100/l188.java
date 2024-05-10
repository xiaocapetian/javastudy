package leetcode100;

public class l188 {
    public int maxProfit(int k, int[] prices) {
        //把l123做成循环
        int[][] dp = new int[prices.length][2*k+1];
        //bp[i] 第i天
        //dp[i][0]//代表不操作  [的最赚状态]
        //dp[i][1]//代表不第一次持有
        //dp[i][2]//代表第一次不持有
        //dp[i][3]//代表第2次持有
        //dp[i][4]//代表第2次不持有

        for(int i = 0;i<=2*k;i++){
            if(i%2==0){dp[0][i]=0;}
            else {dp[0][i]=-prices[0];}
        }
        for (int i = 1; i < prices.length; i++) {
            //不操作
            dp[i][0]=dp[i-1][0];
            for (int j = 1;j<=2*k;j++){
                if(j%2==1) {
                    dp[i][j] = Math.max(dp[i - 1][j],//可能1,之前就持有,没卖
                            dp[i - 1][j-1] - prices[i]);//可能2,之前就不持有,今天买了
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],//可能1,之前就卖了第一次持有的,现在不持有,也不买
                            dp[i-1][j-1]+prices[i]);//可能2,之前持有,今天卖了
                }
            }

        }
        //return Math.max(Math.max(dp[prices.length-1][0],dp[prices.length-1][2]),dp[prices.length-1][4]);
        return dp[prices.length-1][k*2];
    }
}
