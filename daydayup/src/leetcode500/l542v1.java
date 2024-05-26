package leetcode500;

public class l542v1 {
    //动态规划,要从(左上,右下)两个角度规划2次,取最小值
    //想想噢.2次就够了,不用4次
    public int[][] updateMatrix(int[][] mat) {
        int[] dx =new int[]{1,-1,0,0};
        int[] dy =new int[]{0,0,1,-1};
        int[][] dp = new int[mat.length][mat[0].length];
        for(int i= 0;i<mat.length;i++){
            for(int j= 0;j<mat.length;j++){
                dp[i][j]=Integer.MAX_VALUE/2;
            }
        }
        for(int i= 0;i<mat.length;i++){
            for(int j= 0;j<mat[0].length;j++){
                if(mat[i][j]==0){dp[i][j] =0;}
                else {
                    if(i-1>=0){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                    }
                    if(j-1>=0){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                    }
                }
            }
        }
        for(int i= mat.length-1;i>=0;i--){
            for(int j=mat[0].length-1;j>=0;j--){
                if(mat[i][j]==0){dp[i][j] =0;}
                else {
                    if(i+1<mat.length){
                        dp[i][j] = Math.min(dp[i][j],dp[i+1][j]+1);
                    }
                    if(j+1<mat[0].length){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j+1]+1);
                    }
                }
            }
        }
        return dp;
    }
}
