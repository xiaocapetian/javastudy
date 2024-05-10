package leetcode300;

public class l377 {
    public int combinationSum4(int[] nums, int target) {
        int[] bp = new int[target+1];
        bp[0]=1;
        for(int j = 1;j<target+1;j++){
            for(int i = 0;i<nums.length;i++){
                if(j-nums[i]>=0){bp[j] = bp[j]+bp[j-nums[i]];}
            }
        }

        return bp[target];
    }
    public int combinationSum4tt(int[] nums, int target) {
        int[][] bp = new int[nums.length][target+1];
        for(int i = 0;i<nums.length;i++){
            bp[i][0]=1;
        }

        for(int j = 1;j<target+1;j++){
            for(int i = 0;i<nums.length;i++){
                //对于二维其实
                if(j-nums[i]>=0){bp[i][j] = (i>=1?bp[i-1][j]:0) +bp[nums.length-1][j-nums[i]];}
                //求的是排列(有顺序),那就要去上一列最底部的bp[nums.length-1][j-nums[i]]加上去
                //这时候反而一维的好写了
                else {bp[i][j] = (i>=1?bp[i-1][j]:0);}
            }
        }

        return bp[nums.length-1][target];
    }
}
