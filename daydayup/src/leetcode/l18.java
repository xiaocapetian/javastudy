package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l18 {
    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(3, 4, 5);
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0&&nums[i]==nums[i-1]){continue;}
            for (int i1 = i+1; i1 < nums.length-2; i1++) {
                if(i1>i+1&&nums[i1]==nums[i1-1]){continue;}
                int left = i1+1;
                int right = nums.length-1;
                while (left<right){
                    if(left>i1+1&&nums[left]==nums[left-1]){left++;continue;}
                    if(right<nums.length-1&&nums[right]==nums[right+1]){right--;continue;}
                    if((long)nums[i]+nums[i1]+nums[left]+nums[right]-target==0){
                        List<Integer> res = new ArrayList<>(Arrays.asList(nums[i],nums[i1],nums[left],nums[right]));
                        result.add(res);
                        left++;
                        right--;
                        //break;
                    }else if((long)nums[i]+nums[i1]+nums[left]+nums[right]-target>0){
                        right--;
                    }else {
                        left++;
                    }
                }
            }

        }
        return result;
    }
}
