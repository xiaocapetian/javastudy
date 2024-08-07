package leetcode300;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class l300 {
    /**dp[]往前找一个比它小的最大dp[]出来+1
     * 看到l354,在冲一遍吧,            我进步了啊,一遍过!
     * @param nums 给你一个整数数组 nums
     * @return 找到其中最长严格递增子序列的长度
     */
    public int lengthOfLISv4(int[] nums) {

        int[] bp = new int[nums.length];
        int res=0;
        for (int i = 0; i < bp.length; i++) {
            int max = 0;
            //对于每一个i,都要派一个j出去，找所有nums值比它小的中dp[]最大者
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    max = Math.max(max,bp[j]);
                }
            }
            bp[i] = max+1;
            res = Math.max(bp[i],res);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        // 10 1 11 2 4
        // 10 3 11 2 4
        //dp[i]不可以是长度为i的数组的最长子序列,你看上面是不一样的
        //而应该是 以nums[i]结束的 数组的最长子序列    <==这个我现在肯定理解掌握的🙂
        int[] dp = new int[nums.length];
        //dp[0] = 1;
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            dp[i] = 1;//每多考虑一个长度,先把初始化成1,很重要!?===为什么初始化为1?就算前面的全比你大,你起码能自己成一个子序列1对吧
            for (int j = 0;j<i;j++){//为什么要两层循环啊?就是为了找前面所有符合nums[j]<nums[i]的dp[j]的最大值来+1赋给dp[i]啊
                if(dp[j]<dp[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);

        }
        return res;
    }

    /**
     *再次尝试用了超级长的时间才弄出来======实际上我自己用了相当长的时间,自己捣鼓出来就是上面的👆的要求
     * @param nums
     * @return
     */
    public int lengthOfLISv2(int[] nums) {
        int[] dp = new int[nums.length];//这题不用自作聪明在前面加一个补一个0了
        dp[0] = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int maxdpj = 0;   //找到大于的,且dp[j]最大的那个
            while(j>=0){
                if(nums[j]<nums[i]){//这里符号搞清楚
                    maxdpj = Math.max(maxdpj,dp[j]);}
                j--;
            }
            dp[i] = maxdpj+1;
            res = Math.max(dp[i],res);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

}
//想自己写一遍结果反面教材了,这种不要连续的子数组,不应该用dp[i][j]表示从i开始,到j结束的
/*    public int lengthOfLIS2(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(i==j){dp[i][j]=1;}
                else {
                    int temp = j-1;
                    while (temp>=i&&nums[temp]>nums[j]){
                        temp--;
                    }
                    if(temp>=i){
                    if(nums[temp]==nums[j])dp[i][j] = dp[i][temp];
                    if(nums[temp]<nums[j])dp[i][j] = dp[i][temp]+1;}
                }
                res =Math.max(dp[i][j],res);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }*/