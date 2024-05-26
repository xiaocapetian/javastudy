package leetcode200;

import java.util.Arrays;

/**
 * 我自己想了个方法,先降序排序,再两两交换,结果速度最慢...
 * 主要就是排序慢,其实没必要自己写降序
 * 升序也行,从奇数节点开始交换就行
 * 但是这个方法还是不好,去看**[v1]**吧!
 */
public class l280 {
    /**
     * 摆动排序
     * @param nums 给你一个的整数数组 nums, 将该数组重新排序后使 nums[0] <= nums[1] >= nums[2] <= nums[3]...
     */
    public void wiggleSort(int[] nums) {

        //Integer[] numsInteger = new Integer[nums.length];
        for(int i = 0;i<nums.length-1;i++){
            for (int j = 0;j<nums.length-1-i;j++){
                if(nums[j]<nums[j+1]){
                    int swqp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]= swqp;
                }

            }
        }
        //Arrays.sort(nums);

        for(int i= 0;i+1<nums.length;i+=2){
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
    }

    //放聪明一点,降序排序也行
    public void wiggleSortv2(int[] nums) {

        Arrays.sort(nums);
        //交换的是奇数节点就行啦
        for(int i= 1;i+1<nums.length;i+=2){
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
    }

}
