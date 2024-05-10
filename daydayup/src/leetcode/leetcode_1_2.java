package leetcode;

import java.util.HashMap;
//自己写的看来我已经进步了!!!
public class leetcode_1_2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i])){
                res[0] = i;
                res[1] = hash.get(nums[i]);
                return res;
            }else {hash.put(target-nums[i],i);}

        }
        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> hash =new HashMap<Integer,Integer>();
        for(int i =0;i<numbers.length;i++){
            if(!hash.containsKey(numbers[i])){
                hash.put(target-numbers[i],i);
            }else{
                res[0]= hash.get(numbers[i])+1;
                res[1]= i+1 ;
                return res;
            }

            }
        return res;
        }
}
