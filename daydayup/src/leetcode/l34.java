package leetcode;

public class l34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        //if(nums.length ==1){return nums[0]==target?new int[]{0,0}:new int[]{-1,-1};}
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                //一旦发现中间的mid==target
                int start = mid;
                while(start-1>=left&&nums[start-1]==target){
                    start --;//向前
                }
                int end = mid;
                while (end+1<=right&&nums[end+1]==target){
                    end++;//向前后
                }
                return new int[]{start,end};
            }else if(nums[mid]>target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}
