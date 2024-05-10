package leetcode;

public class l53v1 {
    //动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
//请你找出一个具有最大和的连续子数组  因为这道题指出:（子数组最少包含一个元素）所以这样写
        //我把dp向后退了一格当然也可以不退
        int res =  nums[0];
        for (int i = 1;i<=nums.length;i++){
            //dp[i] = Math.max(dp[i-1]+nums[i-1],0);
            dp[i] = nums[i-1]+Math.max(dp[i-1],0);
                    //System.out.print(dp[i]+",");
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    /*自己再写一遍*/
    //dp[i]表示以i结尾的最大连续子序列
    public int maxSubArray2(int[] nums) {
        int bp[] = new int[nums.length];
        int res = nums[0];
        bp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            bp[i] = Math.max(bp[i-1],0)+nums[i];
            res = Math.max(res,bp[i]);
        }
        //res = bp[nums.length-1];
        return res;
    }
}
