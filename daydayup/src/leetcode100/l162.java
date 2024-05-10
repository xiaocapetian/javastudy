package leetcode100;

public class l162 {
    public int findPeakElement(int[] nums) {

        return find(nums,0,nums.length-1);
    }

    private int find(int[] nums, int left, int right) {
        if(left>=right){return left;}

        int mid = (left+right)/2;

        if(nums[mid]<nums[mid+1]){
            return find(nums,mid+1,right);
        }else {
            return find(nums,left,mid);
        }
        /*[易错]这里移动左要left=mid+1;移动右要right = mid*/
    }
}
