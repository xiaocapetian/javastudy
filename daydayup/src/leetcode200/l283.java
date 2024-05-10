package leetcode200;

public class l283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int quick = 0;

        for(;quick<nums.length;quick++){
            if(nums[quick]==0){
                while (quick<nums.length&&nums[quick]==0){
                    quick++;
                }
            }
            if(quick<nums.length){
                nums[slow] = nums[quick];
                slow++;//这个一定要放在这个if里面
            }
        }
        for(;slow<nums.length;slow++){
            nums[slow] = 0;
        }
    }
}

