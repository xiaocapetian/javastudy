package leetcode300;

import java.util.Random;

public class l304v1 {
    class Solution {

        int[] nums;
        Random rand = new Random();
        public Solution(int[] nums) {
            this.nums = nums;
        }
        public int[] reset() {
            return nums;
        }
        public int[] shuffle() {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i];
            }
            for(int i = 0; i < nums.length; i++) {
                int r = rand.nextInt(nums.length-i)+i;
                swap(res,i,r);
            }
            return res;
        }
        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
