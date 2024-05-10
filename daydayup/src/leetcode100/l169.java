package leetcode100;

import java.util.HashMap;
import java.util.Map;

public class l169 {
    //慢但是简单啊
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,(hashMap.getOrDefault(num,0)+1));
        }
        int max=0;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue()>max){
                res = entry.getKey();
                max = entry.getValue();
            }
        }
        return res;
    }
    //如果一个数组有大于一半的数相同，那么任意删去两个不同的数字，新数组还是会有相同的性质。
    public int majorityElement2(int[] nums) {

        int cur = nums[0];
        int time=0;
        for (int i = 1;i<nums.length;i++){

            if(cur==nums[i]){time++;}
            else{
                if(time==0){
                    cur = nums[i];//这里还真不好写一下跳两步呢
                }else {
                    time--;
                }
            }

        }
        return cur;
    }
}
