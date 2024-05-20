package leetcode400;

public class l486v1 {
    public boolean predictTheWinner(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];
        for(int i = dp.length-1;i>=0;i--){
            for (int j =i;j<dp.length;j++){
                if(i==j){
                    dp[i][j] = nums[i];
                    continue;
                }
                //if((j-i)%2==0){
                //其实这里就不需要判断是谁了,上一个在我这一定是负数,我都要最大值
                //那么其实从左上到右下的对角线就是第一个玩家,然后一层一层往右上推,每一层代表同一个玩家的一次选择
                int qingkuang1 = -dp[i][j-1]+nums[j];
                int qingkuang2 = -dp[i+1][j-1]+nums[i];
                dp[i][j] = Math.max(qingkuang1 ,qingkuang2);
                //}

            }
        }
        return dp[0][dp.length-1]>=0;
    }
}
