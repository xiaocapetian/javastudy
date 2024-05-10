package leetcode;

public class l96 {
    public int numTrees(int n) {
        /*对于dp[n] n为头,dp[n-1] ;1为头,dp[n-1] 为什么?因为左边没有元素只有1中情况
        比如1,2,3,4,5, 3为头,左右各放2个,dp[2]*dp[2]
        dp[5] = dp0*dp4+dp1*dp3+dp2*dp2+dp3*dp1+dp4*dp0
        * */

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //dp[2] = 2;//不要这个了

        for(int i = 2; i <=n;i++){
            for(int j = 0 ; j<i;j++){
                dp[i] = dp[i]+dp[j]*dp[i-1-j];
            }

        }
        return dp[n];

    }
}
