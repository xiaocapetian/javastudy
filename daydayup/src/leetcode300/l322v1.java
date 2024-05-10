package leetcode300;

public class l322v1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //初始化第一行
        for(int j = 0;j<amount+1;j++){
            dp[j] = Integer.MAX_VALUE;
        }
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for(int i = 0;i<coins.length;i++){
            //正序遍历：完全背包每个硬币可以选择多次
            for(int j = coins[i];j<amount+1;j++){
//j的初始值保证j-coins[i]>0
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
                //System.out.print(dp[j]+",");
            }
            //System.out.println();
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
