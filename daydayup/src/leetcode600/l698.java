package leetcode600;

import java.util.Arrays;

public class l698 {
    /**
     * nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     * @param nums 给定一个整数数组  nums
     * @param k 和一个正整数 k，
     * @return 找出是否有可能把这个数组分成 k 个非空子集，其总和都相等
     * 回溯法---回溯就是一个树
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % k != 0) return false;
        int target = sum / k;
        int[] basket = new int[k];
        //Arrays.sort(nums);
        /*[重难]数组倒序排序*/
        Integer[] boxednums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxednums,(o1, o2) -> {return o2-o1;});
        nums = Arrays.stream(boxednums).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(nums));
        return tracback(nums,basket,target,0);
    }
    private boolean tracback(int[] nums, int[] basket, int target,int item) {
        if(item==nums.length){return true;}
        for(int i = 0; i < basket.length; i++){
            if(i!=0&&basket[i]==basket[i-1]){continue;}/*[重难]这个剪枝很关键*/
            if(target - basket[i]>=nums[item]){
                basket[i] =basket[i]+nums[item];
                boolean tracback = tracback(nums, basket, target, item+1);
                if(tracback) return true;

                basket[i] =basket[i]-nums[item];
            }
        }
        return false;
    }
}
