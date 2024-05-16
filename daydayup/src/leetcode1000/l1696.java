package leetcode1000;

public class l1696 {
    //是对的，但是超时了
    public int maxResult(int[] nums, int k) {
//从i到(1+1 ~ i+k)不越界
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            int max=Integer.MIN_VALUE;
            for(int j = 1;i-j>=0&&j<=k;j++){//就在这一步太慢了，怎么办
//这一步的目的是找dp[i-k]~dp[i-1]这个滑动窗口的最大值,想到了什么呀?l239滑动窗口的最大值!所以去v1!
                max=Math.max(max,dp[i-j]);
            }
            dp[i] = max+ nums[i];
        }
//System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }
}
