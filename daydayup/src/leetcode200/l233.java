package leetcode200;

/**
 * 会超时,但是如果面试真遇到这道题,起码想到这个方法吧,比做不出来强
 * 看到题目里的提示词:动态规划,就立马写出来了,如果看不到呢,,
 */
public class l233 {
    public int countDigitOne(int n) {

        int[] dp = new int[n+1];
        for(int i = 1;i<n+1;i++){
            dp[i] = dp[i-1]+getiNum(i);
        }
        return dp[n];
    }

    private int getiNum(int i) {
        int count = 0;
        while (i>0){
            int wei = i%10;
            if(wei==1)count++;
            i = i/10;
        }
        return count;
    }
}
