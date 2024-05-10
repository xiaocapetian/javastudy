package leetcode300;

public class l343 {
    public int integerBreak(int n) {

        //dp[i] 代表最大的乘积,
        //dp[i]  = j*(i-j)或j*dp[i-j]  把i拆成j和i-j 且考虑要不要进一步拆分
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i<=n;i++){
            dp[i] = 1;
            for(int j = 1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }

        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
