package leetcode1000;

import java.util.*;

public class l1027 {


    /**
     * @param nums 0 <= nums[i] <= 500
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
        //这个写起来代码很短,非常抽象
        int[][] dp = new int[nums.length][1001];
        //dp[j][d]代表j结尾的子序列,以d为公差的
        int res = 1;
        //比如说这个例子0，2，3，4，6，9，12，15
        for(int k = 0;k<dp.length;k++){//对于一个k来说,用j遍历之前所有的点
            for (int j = 0; j < k; j++) {
                //现在k = 6 j=3 d = 3 dp[6][3] = dp[3][3] +1 = dp[0][3]+2=3
                //现在k = 6 j=4 d =2 dp[6][2] = dp[4][2] +1 = dp[2][2]+2=dp[0][2]+3 = 4
                //
                //那么k = 9 的时候访问到6它找的是d=3!! [也就是说,确定了k和上一个j之后,公差d已经确定]
                //dp[k][d] = dp[j][d] +1; if num[k] -d==num[j]
                int d = nums[k]-nums[j]+500;  //因为在这一步已经变了d
                //if(nums[k] -d==nums[j]){  //千万不能在这一步加这个条件
                dp[k][d] = dp[j][d] +1;
                res = Math.max(dp[k][d],res);
                //}
            }
        }
        return res+1;
    }

    public int longestArithSeqLengthV0(int[] nums) {

        int[] dp = new int[nums.length];
        //int[][] dp = new int[nums.length][1001];
        //dp[i][j]代表以i开头j结尾的子序列👉[压缩维度]-->dp[j]代表j结尾的子序列👉[扩维度]-->dp[j][d]代表以d为公差的

        //100 50 75 50 25 50 0
        //1   2  2  3  4  3  5
        //初始nums[i]和找的这个nums[k]的差/(dp[k]-1)==nums[k]-nums[j],则 可dp[j]=dp[k]+1
        //那么我这个方法是错的
        // 0 3 4 6 8 10
        //反例 0，2，3，4，6，9，12，15那么6的位置会以0 2 4 6存成4而放弃了0 3 6 9 12 15
        //怎么修改呢?扩维度,
        int res = 1;
        for(int i = 0;i<dp.length;i++){
            for (int j = i; j < dp.length; j++) {
                if(j==i)dp[j]=1;
                else if(j==i+1){dp[j]=2;}
                else {
                    //我要派一个往前找
                    int maxdpk=1;
                    for(int k = i+1;k<j;k++){
                        if((nums[i] - nums[k])/(dp[k]-1)==nums[k]-nums[j]){
                            maxdpk=Math.max(maxdpk,dp[k]);
                            //if (i==1){ System.out.println("maxdpk"+maxdpk);}
                        }
                    }
                    dp[j] = maxdpk+1;//dp[j]最少=2

                }
                res = Math.max(dp[j],res);
            }
            //System.out.println(Arrays.toString(dp));

        }

        return res;
    }

}
