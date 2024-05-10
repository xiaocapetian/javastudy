package leetcode;

public class l64 {
    public int minPathSum(int[][] grid) {

        int high = grid.length;
        int wide = grid[0].length;
        int[][] dp =new int[high][wide];
        dp[0][0]=grid[0][0];
        for(int j = 1;j<wide;j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        for(int i = 1;i<high;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i = 1;i<high;i++){
            for(int j = 1;j<wide;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }

        }
        // for(int i = 0;i<high;i++){
        //     for(int j = 0;j<wide;j++){
        //         System.out.print(dp[i][j]+",");
        //     } System.out.println();
        // }
        return dp[high-1][wide-1];
    }
}
