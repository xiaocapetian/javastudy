package leetcode700;

public class l746 {
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length+1];
        //dp[n]定义为到n的最小花费 dp[n] = min( dp[n-1] +cost[n-1], dp[n-2] +cost[n-2])
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
