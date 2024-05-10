package leetcode400;

public class l416v1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;

        return process(nums,0,target,target);

    }

    public boolean process(int[] nums,int index, int target,int orgTarget){
        if(target<0){
            return false;
        }
        if(index==nums.length){
            return false;
        }
        //因为只有正数,优化
        if(nums[index]>orgTarget){return false;}

        if(nums[index]==target){
            return true;
        }

        boolean p1 = process(nums,index+1,target, orgTarget);
        boolean p2 = process(nums,index+1,target-nums[index], orgTarget);

        return p1||p2;
    }
}
