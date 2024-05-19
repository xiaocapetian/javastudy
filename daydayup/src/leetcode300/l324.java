package leetcode300;

import java.util.Arrays;

/**
 * 简单的思路,速度也不慢
 * 排序之后分就行了,奇一个,偶一个
 */
public class l324 {
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int mid = clone.length/2;
        int left;
        if(clone.length%2==1){
            left = mid;
        }else {
            left =mid-1;
        }
        int right = clone.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                nums[i]=clone[left];
                left--;
            }else {
                nums[i] = clone[right];
                right--;
            }
        }
    }
}
