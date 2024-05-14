package leetcode;

public class l96 {
    /**
     * @param n 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * @return 返回满足题意的二叉搜索树的种数。
     */
    public int numTrees(int n) {
        /*对于dp[n] n为头,dp[n-1]*dp[0] = dp[n-1]*1 ; 1为头,dp[n-1] *1
        👆为什么?因为左边没有元素只有1种情况
        2位头，dp[n-2]*dp[1]=dp[n-2]*1👈为什么，左边只可能是1，也是1种情况
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
