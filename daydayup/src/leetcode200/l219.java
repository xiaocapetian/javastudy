package leetcode200;

import java.util.HashMap;

public class l219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else {
                if(i-map.get(nums[i])<=k){return true;}
                else {
                    map.put(nums[i],i);//把前一个给覆盖掉了
                }
            }
        }
        return false;
    }
}
