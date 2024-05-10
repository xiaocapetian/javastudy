package leetcode500;

public class l583 {
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[][] dp = new int[arr1.length+1][arr2.length+1];
        for (int i = 0; i < arr1.length+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < arr2.length+1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < arr1.length+1; i++) {
            for (int j = 1; j < arr2.length+1; j++) {
                if(arr1[i-1]==arr2[j-1]){dp[i][j] = dp[i-1][j-1];}
                else {dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;}
                //这里的区别 是 删arr1 还是删srr2的区别
            }
        }
        return dp[arr1.length][arr2.length];
    }
}
