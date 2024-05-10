package leetcode100;

import java.util.List;
//这题可动态规划!!!可动规啊
//知道可动规后,会写了,就是不知道的时候只知道回溯可,不知动规
public class l120 {
    public int minimumTotal(List<List<Integer>> triangle) {

        int high = triangle.size();
        int[][] dp = new int[high][high];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < high; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0){dp[i][0] = dp[i-1][0]+triangle.get(i).get(0);}
                else if(j==i){
                    dp[i][j] =dp[i-1][j-1]+triangle.get(i).get(j);/*问题在这里,最右一侧也要单独考虑!*/
                }else {
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);}
            }
        }
        int min = dp[high-1][0];
        for (int j = 1; j < high; j++) {
            if(dp[high-1][j]< min){
                min = dp[high-1][j];
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return min;
    }
}
