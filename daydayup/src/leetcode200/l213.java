package leetcode200;

public class l213 {
    public int rob(int[] nums) {
        int[] bp = new int[nums.length];
        if(nums.length==1)return nums[0];
        //要首元素不要尾
        bp[0] = nums[0];
        bp[1] = Math.max(bp[0],nums[1]);
        if(nums.length==2)return bp[1];
        for(int i =2;i<nums.length-1;i++){
            bp[i] = Math.max(bp[i-1],nums[i]+bp[i-2]);
        }
        int res1 = bp[nums.length-2];
        //不要首元素 要尾
        int[] bp2 = new int[nums.length];
        bp2[0] = nums[1];
        bp2[1] = Math.max(bp2[0],nums[2]);
        for(int i =2;i<nums.length-1;i++){
            bp2[i] = Math.max(bp2[i-1],nums[i+1]+bp2[i-2]);
        }
        int res2 = bp2[nums.length-2];
        return Math.max(res1,res2);

    }
}
