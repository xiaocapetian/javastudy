package leetcode1000;

import java.util.Arrays;

public class l1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < k&&i<nums.length; i++) {
            if(nums[i]<0) {nums[i] = -nums[i];}
            else {break;}
        }
        Arrays.sort(nums);
        for (;i<k;i++){
            nums[0] = -nums[0];
        }
        return Arrays.stream(nums).sum();
    }
}
