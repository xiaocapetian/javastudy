package leetcode600;

/**
 * 告诉我四个字,动态规划!我想出来了
 */
public class l678v1 {
    /**
     *    (  *   (   )    )    )
     *    1 012 123 012 -101 -2-10
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        //List<Integer>[] dp = new List[s.length()];
        //List<Integer> dp = new ArrayList<>();
        /*[重难]我优化的很好嘛,不需要list,2个值维护最大最小就够了*/
        int[][] dp= new int[s.length()][2];

        if(s.charAt(0)==')')return false;
        else if(s.charAt(0)=='('){
            //dp[0] = new ArrayList<>();
            //dp[0].add(1);
            dp[0][0] = 1;
            dp[0][1] = 1;
        }else{
            //dp[0] = new ArrayList<>();
            //dp[0].add(0,1);
            dp[0][0] = 0;
            dp[0][1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            //dp[i] = new ArrayList<>();
            if(s.charAt(i)=='('){
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = dp[i-1][1]+1;
            }else if(s.charAt(i)=='*'){
                dp[i][0] = Math.max(dp[i-1][0]-1,0);
                dp[i][1] = dp[i-1][1]+1;
            }else{
                dp[i][1] = dp[i-1][1]-1;
                if(dp[i][1]<0)return false;
                dp[i][0] = Math.max(dp[i-1][0]-1,0);
            }
        }
        if(dp[s.length()-1][0]<=0&&dp[s.length()-1][1]>=0){
            return true;
        }else {
            return false;
        }
    }
}
