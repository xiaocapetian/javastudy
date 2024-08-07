package leetcode600;

import java.util.Arrays;

/**
 * l300 最长递增子序列
 * l673 最长递增子序列的个数
 * 这道题很难啊,很不好思考,很绕😭
 */
public class l673 {
    /**
     * 如果把dp做好,再做后面dpmaxnum 就误入歧途了!(也可以做,见v1)
     * 更重要的是,dpmaxnum[i] 要定义为 😀以i结尾😀，最长增子序列的数目
     * @param nums 给定一个未排序的整数数组 nums ，
     * @return 返回最长递增子序列的个数 。
     */
    public int findNumberOfLIS(int[] nums) {

        //dp[i]定义为 以i结尾，最长增子序列的长度
        int[] dp = new int[nums.length];
        //dpmaxnum[i] 定义为 以i结尾，最长增子序列的数目
        int[] dpmaxnum = new int[nums.length];
        dp[0] = 1;
        int res = 0;
        int maxlen = 1;
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;dpmaxnum[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    //说明 i 可接在j的后面
                    //dp[i] = Math.max(dp[i],dp[j]+1);
                    if(dp[j]+1>dp[i]){
                        //说明i接在j后面,子序列长度最长
                        dp[i] =dp[j]+1;
                        // 如果最长增子序列的长度变了
                        dpmaxnum[i] = dpmaxnum[j];
                    }else if(dp[j]+1==dp[i]){
                        //说明i接在j后面,子序列长度没变(同样能构成最长子序列)  (那就是数量增加了)
                        dpmaxnum[i]+=dpmaxnum[j];
                    }
                }
                maxlen = Math.max(maxlen,dp[i]);
                /*[重难]*/ // 我能在这更新res嘛?
            }
        }
        //我应该怎么得出res? dp[i]==max说明以这一位结尾最长子序列就是 整个数组的最长子序列的情况(之一)
        //那数目是不是应该加到总数呀?!?
        for (int i = 0; i < dp.length; i++) {
            //以i位截止的 [子序列] 是最长的 (之一)
            if(dp[i]==maxlen){
                //以i位截止的 [子序列] 的数目 (加到总数)
                res+=dpmaxnum[i];
            }
        }
        return res;
    }

    //入果把dp[]造出来之后再做int[] dpmaxnum,那就有点复杂
    public int findNumberOfLISV2(int[] nums) {

        int[] dp = new int[nums.length];
        int maxlen = 1;
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            dp[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxlen = Math.max(maxlen,dp[i]);
        }
        //现在dp[i] 是以i结尾的最长子序列的长度，
        //这里的maxnum 应该定义为以i结尾的(最长子序列的数目), 而不是 截至到i,发现的, 最长子序列的数目， 否则容易 导致思维混乱!!!
        int[] dpmaxnum = new int[nums.length];
        dpmaxnum[0] = 1;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            //dpmaxnum[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    //说明nums[i]可以接在nums[j]后面, 其实这时候只有2种情况 : 1.接在后面是最大子序列,2.接在后面,不是最大子序列
                    //情况1:nums[i]正好接在nums[j]后面就是最大子序列
                    if(dp[j]+1==dp[i]){
                        dpmaxnum[i] +=dpmaxnum[j];
                    }
                    //若接在后面,不是最大子序列,不用管
                }
            }
            if(dpmaxnum[i] == 0){dpmaxnum[i] =1;}//如果没有发现dp[j]+1==dp[i],那说明nums[i]不可以接在任何后面,那起码的有一个只有自己的保底的1
        }
        //System.out.println(Arrays.toString(dp));
        //System.out.println(Arrays.toString(dpmaxnum));
        for (int i = 0; i < dp.length; i++) {
            //以i位截止的 [子序列] 是最长的 (之一)
            if(dp[i]==maxlen){
                //以i位截止的 [子序列] 的数目 (加到总数)
                res+=dpmaxnum[i];
            }
        }
        return res;
    }
    /**
     *如果这样先把bp做出了,再考虑maxlen就思维混乱了
     * int[] maxnum应该定义为以i结尾的最长子序列的数目
     */
    public int Error_findNumberOfLIS(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            dp[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        //现在dp[i] 是以i结尾的最长子序列的长度，
        int maxlen = 0;
        //这里的maxnum 应该定义为以i结尾的(最长子序列的数目), 而不是 截至到i,发现的, 最长子序列的数目， 否则容易 导致思维混乱!!!
        int[] maxnum = new int[nums.length];
        maxnum[0] = 1;
        int res = 1;
        for(int i=1;i<nums.length;i++){
            if(dp[i]==dp[i-1]){
                maxnum[i] = maxnum[i-1]+1;
                res = Math.max(res,maxnum[i]);
            }else if(dp[i]>dp[i-1]){
                maxlen = dp[i];
                int j = i-1;
                while(j>=0&&dp[j]!=dp[i]-1){
                    j--;
                }
                maxnum[i] = maxnum[j];
                for(;j>=0;j--){
                    if(dp[j]==dp[i]-1&&nums[j]>=nums[i]){
                        maxnum[i]--;
                    }
                }

                //maxnum = 1;
            }
            System.out.println("i="+i+"dp[i]"+dp[i]+" maxnum[i]="+maxnum[i]+" res="+res+" maxlen="+maxlen);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(maxnum));
        return res;
    }
}
