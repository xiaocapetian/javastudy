package leetcode;

class leecode_1 {
    public int[] twoSum(int[] nums, int target) {
//但是用两个for是找不到工作的
        int[] a =new int [2];
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i+1; i1 < nums.length; i1++) {
                if(nums[i]+nums[i1]==target){
                    //a[0] = nums[i];
                    //a[1] = nums[i+i1];
                    a[0] = i;
                    a[1] = i1;
                    return a;
                }
            }
        }
        return a;
    }

}