package leetcode300;

/**看到了 l673.先刷一次这个
 * 动规5刷了啊。这个肯定要会的
 */
public class l300v1 {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            dp[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(res<dp[i]){
                res = dp[i];
            }
        }
        return res;
    }
}
