package leetcode2000;

public class l2789 {
    /**别人的方法就是写起来简单啊!!!!
     * @param nums 给你一个下标从 0 开始、由正整数组成的数组 nums 。你可以在数组上执行下述操作 任意 次：
     选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。
     将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
     * @return    * 返回你可以从最终数组中获得的 最大 元素的值。
     */
    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){
            //sum = nums[i]<=nums[i+1]?sum+nums[i]:nums[i];
            sum = nums[i]<=sum?sum+nums[i]:nums[i];
        }
        return sum;
    }

    /**
     * @param nums
     * @return
     */
    public long maxArrayValueV2(int[] nums) {
        long[] nums2 = new long[nums.length];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = nums[i];
        }
        for(int i = nums.length-1;i>0;i--){
            if(nums[i]>=nums2[i-1]){
                nums2[i-1] = nums2[i-1]+nums2[i];
            }
        }
        return nums2[0];
    }
}
