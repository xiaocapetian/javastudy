package leetcode900;

import java.util.Random;

/**
 * 快排如果不随机基准点，不能过，随机基准点通过了
 */
public class l912 {
    public int[] sortArray(int[] nums) {

        quick(nums,0,nums.length-1);
        return nums;
    }
    private void quick(int[] nums,int i ,int j ){
        if(i>j){return;}
        int left = i;
        int right = j;
        //找一个随机元素作为基准点
        Random random = new Random();
        int baseNumberItem = random.nextInt(j - i + 1) + i;
        swap(nums,i,baseNumberItem);
        //int baseNumber = nums[i];
        while(left < right){
            while (right>left&&nums[i]<=nums[right]){
                right--;
            }
            while (right>left&&nums[i]>=nums[left]){
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

        }
        int temp = nums[left];
        nums[left] = nums[i];
        nums[i] = temp;
        quick(nums,i,left-1);
        quick(nums,left+1,j);
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
