package leetcode100;

public class l152 {
    public int maxProduct(int[] nums) {
//两个dp数组,一个存乘积最大值,一个存乘积最小值
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpmax[i] = Math.max(Math.max(nums[i]*dpmax[i-1], nums[i]*dpmin[i-1]),nums[i]);
            dpmin[i] = Math.min(Math.min(nums[i]*dpmax[i-1], nums[i]*dpmin[i-1]),nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int j : dpmax) {
            //System.out.println(dpmax[i]);
            max = Math.max(max, j);
        }
        return max;
    }
}
