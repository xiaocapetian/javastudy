package leetcode900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class l904 {
    /**
     * 这个速度慢,但是写起来简单多了,,,,,,还是学这个吧
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int res = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while (map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){map.remove(fruits[left]);}
                left++;

            }
            res = Math.max(right - left+1,res);
        }
        return res;
    }
    /**
     * 双指针终于对了,太复杂了哦,但是它速度快
     * @param fruits
     * @return
     */
    public int totalFruit4(int[] fruits) {
        int res = 0;
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        int[] chong = new int[2];
        chong[0] = fruits[0];
        chong[1] = -1;
        for(;right<fruits.length;right++){
            if(fruits[right]==chong[0]||fruits[right]==chong[1]){
                //System.out.println(Arrays.toString(chong)+"跳,"+(right - left+1));

                //continue;
            }else if (fruits[right]!=chong[0]&&chong[1]==-1){
                chong[1] = fruits[right];
                //System.out.println(Arrays.toString(chong)+"初次,"+(right - left+1));
                //continue;
            }else {
                int liu = fruits[right-1];
                if(chong[0]==liu){
                    chong[1]=fruits[right];
                }else {
                    chong[0]=fruits[right];
                }
                left = right-2;
                while (fruits[left]==fruits[left+1]){
                    left--;
                }
                left++;
                //System.out.println(Arrays.toString(chong)+"改之后,"+(right - left+1));
            }

            res = Math.max(right - left+1,res);
        }
        return res;
    }
    /**
     * 动规
     * 不用set,用一个2长度数组判断,速度又提升了,但是还是超时,
     * @param fruits
     * @return
     */
    public int totalFruit3(int[] fruits) {


        int[] dp = new int[fruits.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            //Set<Integer> set = new HashSet<>();
            int[] chong = new int[2];
            for(int j = i;j<dp.length; j++){
                if(i==j){
                    dp[j] = 1;
                    chong[0] = fruits[j];
                    chong[1] = -1;
                }else if(dp[j-1]!=0){
                    if(fruits[j]!=chong[0]&&chong[1]==-1){
                        chong[1] = fruits[j];
                        dp[j] = dp[j-1]+1;
                    }else if(fruits[j]==chong[0]||fruits[j]==chong[1]){
                        dp[j] = dp[j-1]+1;
                    }else {
                        dp[j] = 0;
                    }
                }else {
                    break;
                }
                res = Math.max(dp[j],res);
            }
        }
        return res;
    }

    /**
     * 改成一维,动规还是超时
     * @param fruits
     * @return
     */
    public int totalFruit2(int[] fruits) {


        int[] dp = new int[fruits.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i;j<dp.length; j++){
                if(i==j){
                    dp[j] = 1;
                    set.add(fruits[j]);
                }else if(dp[j-1]!=0){
                    set.add(fruits[j]);
                    if(set.size()>2){
                        dp[j] = 0;
                    }else {
                        dp[j] = dp[j-1]+1;
                    }
                }else {
                    break;
                }
                res = Math.max(dp[j],res);
            }
        }
        return res;
    }

    /**
     * 这题没必要二维
     * @param fruits
     * @return
     */
    public int totalFruit1(int[] fruits) {


        int[][] dp = new int[fruits.length][fruits.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i;j<dp.length; j++){
                if(i==j){
                    dp[i][j] = 1;
                    set.add(fruits[j]);
                }else if(dp[i][j-1]!=0){
                    set.add(fruits[j]);
                    if(set.size()>2){
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = dp[i][j-1]+1;
                    }
                }
                res = Math.max(dp[i][j],res);
            }
        }
        return res;
    }
}
