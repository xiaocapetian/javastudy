package leetcode1000;

public class l1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int stone : stones) {
            sum += stone;
        }
        int target = sum/2;

        System.out.println(sum);
        System.out.println(target);
        int[][] dp = new int[stones.length][target+1];
        for(int j = 0;j<target+1;j++){
            if(j>=stones[0]){dp[0][j]=stones[0];}
            else{dp[0][j]=0;}
        }

//之前bp数组的定义错了,j应该从0加到target,bp[i][j]应该是最接近j(背包总量)的和,而不是最接近target的和
        //因为dp[i-1][j-stones[i]]+stones[i]就是说加上(比如5),且之前最接近(target去除5)的值
        for(int i = 1; i < stones.length; i++){
            for(int j = 1;j<target+1;j++){
                if(j<stones[i]){
                    dp[i][j] =dp[i-1][j];continue;
                }
                int a = dp[i-1][j];
                int b = dp[i-1][j-stones[i]]+stones[i];


                dp[i][j] = Math.abs(target-a)< Math.abs(target-b)?a:b;
            }
        }
        for(int i = 0; i < (stones.length); i++){
            for(int j = 1;j<target+1;j++){
                System.out.print(dp[i][j]+",");}
            System.out.println();}
        int result = Math.abs(target-dp[stones.length-1][target]);
        if(sum%2==1){
            return  result*2+1;
        }
        return result*2;
    }
}
