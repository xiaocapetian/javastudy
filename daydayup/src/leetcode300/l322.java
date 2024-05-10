package leetcode300;

public class l322 {

    /*不满足不要写-1,写最大值,*/          //这种题为什么可以用一维替代二维啊,因为只和当上一行此位置(一维此位置原始值)以及此行前位置有关
    //一维dp反而简单,而且速度快.这应该是最好的方法
    public int coinChange2(int[] coins, int amount) {
        int no = Integer.MAX_VALUE;
        int[] dp = new int[amount+1];
        //初始化第一行
        for(int j = 1;j<amount+1;j++){
            dp[j] = no;
        }
        dp[0] = 0;//这个不能缺了
        //System.out.println();
        for(int i = 0;i<coins.length;i++){
            for(int j = coins[i];j<amount+1;j++){
                /*这里改进就是int j = coins[i]从这开始,直接保证*/
                if(dp[j-coins[i]]!=no){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount] == no?-1:dp[amount];
    }
    //23.4.6再刷,第一反应想到的是二维dp,没想到二维dp还挺复杂,速度也慢
    public int coinChange3(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        dp[0][0]=0;
        for (int j = 1; j < dp[0].length; j++){
            if(j-coins[0]>=0&&dp[0][j-coins[0]]!=Integer.MAX_VALUE){
                dp[0][j] =dp[0][j-coins[0]]+1;
            }else {
                dp[0][j] =Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j-coins[i]>=0&&dp[i][j-coins[i]]!=Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j-coins[i]]+1,dp[i-1][j]);
                }else {
                    dp[i][j] =dp[i-1][j];
                }
            }
        }
        return dp[coins.length-1][amount]==Integer.MAX_VALUE?-1:dp[coins.length-1][amount];
    }

    /*自己写的一版判断复杂了*/
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //初始化第一行
        for(int j = 0;j<amount+1;j++){
            if(j%coins[0]==0){dp[j]=j/coins[0];}
            else {dp[j] = -1;}
            //System.out.print(dp[j]+",");
        }
        //System.out.println();
        for(int i = 1;i<coins.length;i++){
            for(int j = 0;j<amount+1;j++){

                if(j-coins[i]>0){
                    if(dp[j]!=-1&&dp[j-coins[i]]!=-1){
                        dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                    }else if(dp[j-coins[i]]!=-1){
                        dp[j] =dp[j-coins[i]]+1;}
                }else if(j-coins[i]==0){
                    dp[j] = 1;
                }
                //System.out.print(dp[j]+",");
            }
            //System.out.println();
        }
        return dp[amount];
    }
}
