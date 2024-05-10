package leetcode900;

/**
 * 环形子数组的最大和
 */
public class l918 {
    //前置题目 子数组最大和 不就是面试面的那个l53嘛!
    public int maxSubarraySumCircular(int[] nums) {
        //这个思路绝了啊,不跨边界的算一个最大值
        //跨边界的,算一个最大值----怎么算呢,算不跨边界的最小值,那剩下来的值就是最大值了

        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        //那么首先不跨边界的算一个最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max1 = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(0,dp[i-1])+nums[i];
            max1 = Math.max(max1,dp[i]);
        }
        //再算不跨边界的最小值
        int[] dp2 = new int[nums.length];
        dp2[0] = nums[0];
        int min = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp2[i] = Math.min(0,dp2[i-1])+nums[i];
            min= Math.min(min,dp2[i]);
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(dp2));
        //还有特殊情况要考虑  比如[-9,-9,1,1,-9,-9 ],[-3,-2,-3]这是不可以的对吧,这个时候min==sum,
        // 那么👇如果最小值=sum说明不用第二种方法了,只考虑第一种就行
        if(min==sum){
            return max1;
        }else {
            return Math.max(sum-min,max1);
        }
    }
}
//        作者：灵茶山艾府
//        链接：https://leetcode.cn/problems/maximum-sum-circular-subarray/solutions/2351107/mei-you-si-lu-yi-zhang-tu-miao-dong-pyth-ilqh/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
