package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l18v1 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(fourSum(nums,8));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0&&nums[i]==nums[i-1]){continue;}
            for (int j = i+1; j < nums.length-2; j++) {
                if(j>i+1&&nums[j]==nums[j-1]){continue;}
                /*去重的点,两层循环j从i+1开始,那么去重的时候也要,按照套路!!!j>i+1*/
                int left = j+1;
                int right = nums.length-1;
                //int tar = target-nums[i]-nums[j];
                //long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                while (left<right){
                    if((long) nums[i] + nums[j] + nums[left] + nums[right]>target){right--;}
                    else if((long) nums[i] + nums[j] + nums[left] + nums[right]<target){left++;}
                    else {//if(nums[right]+nums[left]==tar)
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        res.add(list);

                        while (left<right&&nums[right]==nums[right-1]){right--;}
                        while (left<right&&nums[left]==nums[left+1]){left++;}
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
