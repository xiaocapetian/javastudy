package leetcode;

public class l35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length-1;
        while (left<=right){//这里一定要写小于等于!!!!!!!!!!!
            //int mid = (right+left)/2;//可能会溢出
            int mid = ((right - left) >> 1) + left;//要这么写

            if(nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }

        }
        return left;

    }
}
