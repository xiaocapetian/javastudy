package leetcode;

public class l97 {
    //看答案知道了dp[i][j]含义后一遍过了
    public boolean isInterleave(String s1, String s2, String s3) {

        char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();
        char[] s3a = s3.toCharArray();
        if(s1.length()+s2.length()!=s3.length())return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        //dp[i][j]表示 s1的前i个和s2的前j个能否组成s3的前i+j个
        dp[0][0] = true;
        for (int i = 1; i < s1.length()+1; i++) {
            if(s1a[i-1] ==s3a[i-1] &&dp[i-1][0]){dp[i][0]=true;}
        }
        for (int j = 1; j < s2.length()+1; j++) {
            if(s2a[j-1] ==s3a[j-1] &&dp[0][j-1]){dp[0][j]=true;}
        }
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                if(dp[i][j-1]&&s2a[j-1] == s3a[i+j-1]){dp[i][j]=true;}
                if(dp[i-1][j]&&s1a[i-1] == s3a[i+j-1]){dp[i][j]=true;}
                //如果左边的符合,那就需要你这位等于上面的s2
            }
        }


        return dp[s1.length()][s2.length()];
    }
}
