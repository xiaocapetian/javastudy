package leetcode700;

public class l718 {
    public int findLength(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums2.length+1][nums1.length+1];
        /*难点一,想到用二维dp,一列是num1,一行num2

        难点二,不是i的num2和j的num1的最长的子序列,而是以i结尾和以j结尾的最长子序列
        这样只要判断当nums2[i-1] == nums1[j-1]时,dp[i][j] = dp[i-1][j-1]+1; 相对左上角+1

        难点三,数组整体向右下角移一格,这样就不用初始化了,第一行第一列全赋值0
        * */

        int res = 0;
        for (int i = 1; i < nums2.length+1; i++) {
            for (int j = 1; j < nums1.length+1; j++) {
                if(nums2[i-1] == nums1[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res,dp[i][j]);
                }

            }
        }
        for (int i = 0; i < nums2.length+1; i++) {
            for (int j = 0; j < nums1.length+1; j++) {
                System.out.print(dp[i][j]+",");}System.out.println();
        }

        return res;
    }
}
