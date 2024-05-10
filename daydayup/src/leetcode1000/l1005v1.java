package leetcode1000;

import java.util.Arrays;

public class l1005v1 {
    //根据随想录写的,但是很慢..
    public int largestSumAfterKNegations(int[] nums, int k) {
        absSort(nums);
        //System.out.println(Arrays.toString(nums));
        for (int i = 0;k>0&&i<nums.length;i++){
            if(nums[i]<0){
                nums[i] = -nums[i];
                k--;
            }
        }
        if(k>0&&k%2==1){nums[nums.length-1] = - nums[nums.length-1];}
        return Arrays.stream(nums).sum();
    }
    public void absSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j<nums.length-1-i;j++){
                if(Math.abs(nums[j])<Math.abs(nums[j+1])){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        //       return nums;
    }
}
