package leetcode;

public class l53 {//面试就面的这道题,第一反应还是这种解法
    //l918变成环形子数组最大和了
    public int maxSubArray(int[] nums) {

        //int left = 0;
        int right = 0;
        int sum = 0;
        int max = nums[0];
        for(;right<nums.length;right++){
            //这个要放在每次的第一步判断_原因是如果子数组只有负数也得要
            if(sum<0){
                //left = right;
                sum = 0;
            }
            sum = sum+nums[right];
            if(max<sum){max =sum;}
            //System.out.println("sum= "+sum);
        }
        return max;
    }
}
