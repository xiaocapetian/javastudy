package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class l118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        for(int i = 0 ;i<numRows;i++){
            dp[i][0]=1;
        }

        for(int i = 1 ;i<numRows;i++){
            //List<Integer> hang = new ArrayList<>();
            for(int j = 1 ;j<numRows;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                //if(dp[i][j]>0){hang.add(dp[i][j]);}
            }
            //res.add(hang);
        }
        for(int i = 0 ;i<numRows;i++){
            List<Integer> hang = new ArrayList<>();
            for(int j = 0 ;j<numRows;j++){
                if(dp[i][j]>0){hang.add(dp[i][j]);}
            }res.add(hang);
        }
        return res;
    }
}
