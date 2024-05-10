package leetcode300;

public class l392v1 {
    public boolean isSubsequence(String s, String t) {
        //自己用动规写的,用的是boolean[][]
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        boolean[][] dp = new boolean[sarr.length+1][tarr.length+1];
        for (int j = 0;j<tarr.length+1;j++){
            dp[0][j] = true;}
        for (int i = 1;i<sarr.length+1;i++){
            for (int j = 1;j<tarr.length+1;j++){
                if(sarr[i-1]==tarr[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {dp[i][j] = dp[i][j-1];}
            }
        }
        //         for (int i = 1;i<sarr.length+1;i++){
        //     for (int j = 1;j<tarr.length+1;j++){
        //         System.out.print(dp[i][j]+",");
        //     }
        //     System.out.println();
        // }
        return dp[sarr.length][tarr.length];
    }
}
