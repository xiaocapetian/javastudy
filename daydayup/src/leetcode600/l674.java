package leetcode600;

public class l674 {
    public int findLengthOfLCIS(int[] nums) {

        int[] bp = new int[nums.length];
        bp[0]=1;
        int res = 1;
        for(int i= 1;i<nums.length;i++){
            bp[i]=1;
            if(nums[i-1]<nums[i]){bp[i]=bp[i-1]+1;}
            res = Math.max(res, bp[i]);
        }
        return res;
    }
}
