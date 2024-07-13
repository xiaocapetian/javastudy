package leetcode400;

import java.util.Arrays;

public class l453 {
    /**
     * 我直接想到取对n - 1个数加1等价于对一个数-1最小值然后巴拉巴拉
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {

        int min = Arrays.stream(nums).min().getAsInt();

        int res=0;
        for(int i = 0;i<nums.length;i++){
            res+=nums[i]-min;
        }
        return res;
    }
}
