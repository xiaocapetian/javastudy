package leetcode600;

import java.util.Arrays;

public class l611 {
    /**排序+二分查找    ==更好的思路,排序+双指针
     * 不是很快,但是是自己的思路,好在没超超时   而且和官解的第一个思路是一致的,非常正确!
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);
        int res = 0;
        int i = 0;
        //while (nums[i] == 0){
        while (i<nums.length&&nums[i] == 0){ /*易错 */
            i++;
        }
        for(;i<nums.length-2;i++){
            /*👇易错  不是从1开始,是从i+1开始*/
            //for(int j = 1;j<nums.length-1;j++){
            for(int j = i+1;j<nums.length-1;j++){
                int wei = find(i,j,nums)-1;
                res+=wei-j;
            }
        }
        return res;
    }

    private int find(int i,int j,int[] nums) {
        int target = nums[i]+nums[j];
        int left=j+1;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(target==nums[mid]){
                /*[易错!重难点!]这里不能直接简单的二分查找,如果mid周围又相等的值应该找到最前的一个,举例 1 3 3 3 3 4 4,不能取第4个而应该取第2个!*/
                while (mid-1>i&&nums[mid-1]==nums[mid]){
                    mid--;
                }
                return mid;
            }else if(target>nums[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        System.out.println("left="+left);
        return left;
    }
}
