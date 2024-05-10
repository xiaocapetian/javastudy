package leetcode1000;

public class l1143v1 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();
//不要求连续,那dp[i][j]就定成i,j的最大长度
        //要求连续,那dp[i][j]就定成 以i,j结尾的最大长度!  l718
        int[][] dp = new int[nums2.length+1][nums1.length+1];

        //int res = 0;
        for (int i = 1; i < nums2.length+1; i++) {
            for (int j = 1; j < nums1.length+1; j++) {
                if(nums2[i-1] == nums1[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;

                    //res = Math.max(res,dp[i][j]);
                }
                else{dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);}
                //dp[i][j]= Math.max(dp[i][j],Math.max(dp[i][j-1],dp[i-1][j]));
            }
        }
        for (int i = 0; i < nums2.length+1; i++) {
            for (int j = 0; j < nums1.length+1; j++) {
                System.out.print(dp[i][j]+",");}System.out.println();
        }

        return dp[nums2.length][nums1.length];
    }
}
