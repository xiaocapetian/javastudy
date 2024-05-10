package leetcode1000;

public class l1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //注意,实践证明,转成数组 更快,比起str.charat()
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();

        int[][][] dp = new int[nums2.length+1][nums1.length+1][2];
//根据l718的思想,设了[0][1]两种状态,[0]仍然是以i结尾和以j结尾的最长子序列 ,[1]就变成最大值了,其实可以合并,见v1
        int res = 0;
        for (int i = 1; i < nums2.length+1; i++) {
            for (int j = 1; j < nums1.length+1; j++) {
                if(nums2[i-1] == nums1[j-1]){
                    dp[i][j][0] = dp[i-1][j-1][1]+1;

                    res = Math.max(res,dp[i][j][0]);
                }
                dp[i][j][1] = Math.max(dp[i][j][0],Math.max(dp[i][j-1][1],dp[i-1][j][1]));
            }
        }
        for (int i = 0; i < nums2.length+1; i++) {
            for (int j = 0; j < nums1.length+1; j++) {
                System.out.print(dp[i][j][0]+",");}System.out.println();
        }

        return res;
    }
}
