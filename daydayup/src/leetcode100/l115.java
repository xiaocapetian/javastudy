package leetcode100;

public class l115 {
    public int numDistinct(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int[][] dp = new int[tarr.length+1][sarr.length+1];
        for(int j = 0 ;j<=sarr.length;j++){dp[0][j]=1;}
        for(int i = 1 ;i<=tarr.length;i++){
            for(int j = 1 ;j<=sarr.length;j++){
                if(sarr[j-1]==tarr[i-1]){
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1];}//注意这里是:{dp[i-1][j-1]
                //dp[i][j-1] 不使用  + dp[i-1][j-1]使用
                else {dp[i][j] = dp[i][j-1];}
                //dp[i][j-1] 只能不使用
            }
        }
        //     for(int i = 0 ;i<=tarr.length;i++){
        // for(int j = 0 ;j<=sarr.length;j++){
        //     System.out.print(dp[i][j]+",");
        // }
        // System.out.println();}
        return dp[tarr.length][sarr.length];
    }
}
