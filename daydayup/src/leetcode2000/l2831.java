package leetcode2000;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l2831 {
    /**
     * 看提示看到滑动窗口4个字来思路了,但是经过长期的改，还是做不出来，太麻烦了，😭😭
     * @param nums 给你一个下标从 0 开始的整数数组 nums
     * @param k
     * @return 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
               从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。子数组 是数组中一个连续且可能为空的元素序列。
     */
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int left=0;
        int right=1;

        Map<Integer,Integer> map =new HashMap<>();
        //数字  和它的数量
        if(nums.isEmpty())return 0;
        int res=1;
        int maxNum = nums.get(0);
        map.put(nums.get(0),1);
        for(;right<nums.size()&&right-map.get(maxNum)<k;right++){
            int now = nums.get(right);
            map.put(now,(map.getOrDefault(now,0)+1));
            if(map.get(now)>map.get(maxNum)){
                maxNum = now;
            }
            res = Math.max(res,map.get(maxNum));
        }
        while (right<nums.size()) {
            int now = nums.get(right);
            map.put(now,map.getOrDefault(now,0)+1);
            if(now!=maxNum){

                if(map.get(now)>map.get(maxNum)){
                    //要换最大值
                    maxNum = now;
                }else if(map.get(now)==map.get(maxNum)){
                    //不换
                    if(right-1<nums.size()&&nums.get(right+1)==now){
                        //要换最大值
                        maxNum = now;
                    }
                }
                while (left<right&&nums.get(left)==maxNum){
                    map.put(nums.get(left),map.get(nums.get(left))-1);
                    left++;
                }
                if(nums.get(left)!=maxNum){map.put(nums.get(left),map.get(nums.get(left))-1);
                    left++;
                }
            }
            res = Math.max(res,map.get(maxNum));
            right++;
            System.out.println("maxNum"+maxNum);
        }

        return res;
    }
}
