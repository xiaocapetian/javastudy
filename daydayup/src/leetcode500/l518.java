package leetcode500;

public class l518 {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];

        dp[0] =1;
        for(int i= 0;i<coins.length;i++){

            for (int j = 1;j<amount+1;j++){

                if(j>=coins[i]){
                    dp[j] = dp[j]+dp[j-coins[i]];
                }
                //System.out.print(dp[j]+",");
            }
            //System.out.println();
        }

        return dp[amount];
    }
}
