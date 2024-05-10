package leetcode;

public class l31_1 {
    public void nextPermutation(int[] nums) {
        //学习一下lcode官方答案怎么写的
        int min = nums.length-2;
        while (min >= 0 && nums[min] >= nums[min + 1]) {
            min--;
        }
        if (min >= 0) {
            int ci = nums.length - 1;
            while (ci >= 0 && nums[min] >= nums[ci]) {
                ci--;
            }
            swap(nums, min, ci);
        }
        reverse(nums, min + 1);

    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
