package leetcode;

public class l26 {
    //双指针，自己写的——难点在于想到这题是双指针
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 1;
        for (; fast < nums.length; fast++) {
            if (nums[fast]!=nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
