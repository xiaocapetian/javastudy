package leetcode;

public class l81 {

    public boolean search(int[] nums, int target) {

        return erfen(nums, target, 0, nums.length - 1);


    }
    private boolean erfen(int[] nums, int target,int left,int right){
        //若left<mid
        //      若 left< tar< mid 左
        //若left>mid
        //
        //若left==mid
        //      不知道在做还是在右,两个都要查
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)return true;
            if(nums[left]<nums[mid]){
                if(nums[left]<=target&&target<nums[mid]){/*[难点] nums[left]<=target*/
                    right=mid-1;//往左找
                }else {
                    left=mid+1;
                }
            }else if(nums[left]>nums[mid]){//nums[left]>nums[mid]
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;//往右找
                }else {
                    right=mid-1;
                }

            }else {
                return erfen(nums,target,left,mid-1)||erfen(nums,target,mid+1,right);
            }
        }
        return false;
    }
}
