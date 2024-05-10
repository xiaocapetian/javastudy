package leetcode500;

import java.util.HashMap;
import java.util.Map;

public class l560 {
    /*这道题并不需要使用动态规划，因为动态规划通常用于解决具有最优子结构性质的问题，而该问题并不具备这样的性质。
 动态规划通常适用于以下情况：
      问题具有最优子结构性质，即原问题的最优解可以由子问题的最优解推导而来。
      问题的状态可以被描述为状态转移方程，即问题可以被拆解成一系列子问题，并且问题的解可以通过求解这些子问题的解来获得。*/
    //自己写的
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum+=nums[j];
                if(sum==k){res++;}
            }
        }
        return res;
    }
    //官解法的第一版,和我差不多,变方向
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            int sum = 0;
            for (int left = right; left >= 0; left--) {
                sum += nums[left];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    //根据官解第二版的思想我自己写的,怎么时间还边长了啊!!!
    /*  pre[i]表示从0到i的和,  pre[i]- pre[j-1]==k说明从j到i的和符合
    * */
    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        int[] pre = new int[nums.length];
        for (int right = 0; right < nums.length; right++) {
            pre[right] = right == 0?nums[right]:pre[right-1]+nums[right];

            for (int left = right; left >= 0; left--) {
                if (pre[right]-(left == 0?0:pre[left-1])==k) {
                    count++;
                }
            }
        }
        return count;
    }
    //官解第二版再更进一步,map存的是什么?存键是从0加到此的和,值是重复的就加1   也就是存pre[j-1]
    /*pre是到目前位置的和,pre-k若在map里找到了,那就把值取出来加*/
    public int subarraySum4(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int right = 0; right < nums.length; right++) {
            pre=pre+nums[right];

            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }


}
