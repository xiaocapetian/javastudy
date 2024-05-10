package leetcode500;

public class l516 {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j] 代表从第j位到第i位字串是不是回文串 注意是[j,i] ,dp数组是左下角的半三角
        //当然也可以写成[i,j]那就是右上角三角,且遍历顺序要变
        char[] sarr = s.toCharArray();
        int[][] dp = new int[sarr.length][sarr.length];
        for(int i = 0;i<sarr.length;i++){
            for(int j = i;j>=0;j--){
                //如果长度只有1
                if(i==j){dp[i][j]=1;}
                //如果长度只有2,这个也可以不用单独指定,
//                else if(i==j+1){
//                    if(sarr[i]==sarr[j]){dp[i][j]=2;}
//                    else {dp[i][j]=1;}
//                }
                //如果长度2以上
                else if(sarr[i]==sarr[j]){dp[i][j]=dp[i-1][j+1]+2;}
                else {
                    dp[i][j]=Math.max(dp[i][j+1],dp[i-1][j]);
                }
            }}
        //                     for(int i = 0;i<sarr.length;i++){
        //     for(int j = 0;j<sarr.length;j++){
        //         System.out.print(dp[i][j]+",");
        //     }
        //     System.out.println();
        // }
        return dp[sarr.length-1][0];
    }
}
