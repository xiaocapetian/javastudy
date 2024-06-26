package leetcode;

public class l44 {

    public boolean isMatch(String s, String p) {

        //p可能会出现通配符
        boolean[][]  dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for(int i = 1;i<dp.length;i++){
            if(p.charAt(i)=='*'){dp[i][0] = dp[i-1][0];}
        }
        for(int j = 1; j < dp[0].length; j++){
            if(s.charAt(j)=='*'){dp[0][j] = dp[0][j-1];}
        }
        for(int i = 1;i<dp.length;i++){
            for (int j = 1; j < dp[0].length; j++) {
                if(p.charAt(i)=='*'){
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-1]||dp[i][j-1];
                }else if(p.charAt(i)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
