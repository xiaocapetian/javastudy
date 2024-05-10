package leetcode400;

/**
 * v1是回溯解法,超时的
 */
public class l416 {
    /*但是把这个转成背包问题很难理解啊!*/
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2!=0)return false;
        int[] dp = new int[sum/2+1];
        for(int i = 0;i<nums.length;i++){
            for(int j = sum/2;j>=nums[i];j--){
                //为什么这里j要从后往前写?因为和前面的有关啊
                //dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);

            }
            if (dp[sum/2]==sum/2)return true;
        }
        return false;

    }
    public boolean canPartition2(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum/2;
        if(sum%2!=0)return false;
        boolean[][] dp = new boolean[nums.length][sum/2+1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for(int i = 1;i<nums.length;i++){//i是可能的选择
            for(int j = 0;j<=target;j++){//j是背包的容量
                if(j<nums[i]){dp[i][j] =dp[i-1][j];continue;}
                if(j==nums[i]){dp[i][j] = true;continue;}//如果某个物品单独的重量恰好就等于背包的重量，那么也是满足dp数组的定义的
                //if(j<nums[i]){dp[i][j] =dp[i-1][j]; }

                //dp[i-1][j]表示该物品不放入背包      ，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，
                //dp[i-1][j-nums[i]]表示该物品放入背包。如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。
                if (nums[i] < j) {
                dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]];}
                //要它,之前的和 =  j - nums[i] || 不要它,之前的和==j
                //只要满足一个那这个就满足
            }
            //if (dp[i][sum/2]==sum/2)return true;
        }
        return dp[nums.length - 1][target];

    }
}
