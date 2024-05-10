package leetcode200;

public class l221 {
    //自己写的噢
    public int maximalSquare(char[][] matrix) {

        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(i==0){dp[0][j]=(matrix[0][j]=='1'?1:0);}//初始化第一排
                else if(j==0){dp[i][0]=(matrix[i][0]=='1'?1:0);}//初始化第一列
                else {
                    if(matrix[i][j]=='0'){dp[i][j] = 0;}
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;//别犯低级错误dp是根据dp算的
                        //只和左,上,左上的最小值有关
                    }
                }
                max = Math.max(max,dp[i][j]);//注意要写在这一层
            }
        }
        //         for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return max*max;
    }
}
