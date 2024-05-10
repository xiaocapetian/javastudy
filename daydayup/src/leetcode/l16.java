package leetcode;

import java.util.Arrays;

public class l16 {
    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5}; int target = -2;
        System.out.println(threeSumClosest(nums, target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println();
        int min = Math.abs(nums[0]+nums[1]+nums[nums.length-1]-target);
        int sum = nums[0]+nums[1]+nums[nums.length-1];
        for (int first = 0; first < nums.length; first++) {
            if(first>0&&nums[first]==nums[first-1]){continue;}
            int cha = target - nums[first];
            for (int second = first+1; second < nums.length-1; second++) {
                if(second>first+1&&nums[second]==nums[second-1]){continue;}
                int third = nums.length-1;
                while(second<third){
                    if(Math.abs(cha-nums[second]-nums[third])<min){
                        min = Math.abs(cha-nums[second]-nums[third]);
                        //System.out.println("first = "+nums[first]+"second = "+nums[second]+"third = "+nums[third]+"sum"+sum);
                        sum = nums[first]+nums[second]+nums[third];
                        if(min == 0){return sum;}
                    }
                    third--;
                }
            }
        }
        return sum;
    }
}
