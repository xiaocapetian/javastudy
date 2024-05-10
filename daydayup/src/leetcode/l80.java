package leetcode;

public class l80 {
    //我抄我厉害啊
    public int removeDuplicates(int[] nums) {

        int right = 2;
        int write = 2;//就负责写
        int left = 0;
        while (right<nums.length){
            nums[write] = nums[right];//right尽管在前面冲
            if(nums[left]==nums[right]){
                right++;
            }else {
                left++;
                write++;
                right++;
            }
        }
        return write;
    }
}
