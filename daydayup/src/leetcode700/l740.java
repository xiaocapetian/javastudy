package leetcode700;

/**
 * 自己想的动规方法哦
 * 这不就是那个打家劫舍的翻版嘛！
 */
public class l740 {
    public int deleteAndEarn(int[] nums) {

        int[] tongji = new int[10001];
        int max=0;
        for (int num : nums) {
            max = Math.max(num,max);
            tongji[num]+=num;
        }
        int[] dp = new int[max+1];
        dp[1] = tongji[1];
        //dp[2] = tongji[2];
        for(int i = 2;i<max+1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+tongji[i]);
        }
        //System.out.println(Arrays.toString(dp));
        return dp[max];
    }
}
