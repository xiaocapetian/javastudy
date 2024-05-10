package leetcode;

import java.util.HashSet;
import java.util.Set;

public class l41 {
    //能想到这个就不错了把,
    //建一个hashset
    public int firstMissingPositive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        while (true){
            if(!set.contains(res)){
                return res;
            }
            res++;
        }
    }
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        //只在意数组中(1,n)的数
        //第一遍,先把所有<= 0 的数修改为 N+1；
        //第二遍,出现一个(1,n)的数z,就把z-1的位置打标记,设成负数.
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]<=0){nums[i] = n+1;}
        }
        for (int i = 0; i < nums.length; i++) {
            int num =Math.abs(nums[i]);
            if(num<=n){///NUM有,就要把
                nums[num-1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){return i+1;}
        }
        return n+1;

    }
}
