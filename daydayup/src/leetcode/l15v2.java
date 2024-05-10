package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//二刷
public class l15v2 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i!=0&&nums[i]==nums[i-1]){continue;}//第一处去重
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                if(nums[left]+nums[right]==target){
                    List<Integer> list =new ArrayList<>();
                    list.add(nums[i]);list.add(nums[left]);list.add(nums[right]);
                    res.add(list);
                    left++;right--;
                    while (left<right&&nums[left]==nums[left-1]){left++;}//第二处去重
                    while (left<right&&nums[right]==nums[right+1]){right--;}
                }else if(nums[left]+nums[right]>target){
                    right--;
                }else {
                    left++;
                }
            }

        }
        return res;
    }
}
