package leetcode200;

public class l279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int no = Integer.MAX_VALUE;
        for(int j = 0;j<n+1;j++){
            dp[j] = no;
        }
        dp[0] = 0;//!!!这句很重要!!!!
        //为什么0重要?因为对于16,4方可,但是前面都是x,上面也是x,怎么把4方弄出1来?就是前面的这个0啊!
        for(int i = 100;i>0;i--){
            for(int j = i*i;j<n+1;j++){
                if(dp[j-i*i]!=no){
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);}
            }
        }
        return dp[n];
    }
}
