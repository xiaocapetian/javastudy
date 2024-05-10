package leetcode100;

import java.util.HashMap;
import java.util.Map;

public class l136 {
    //哈希表法，可以解就是慢
    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int num : nums) {
            //hash.getOrDefault(num,0)
            if(hash.containsKey(num)){
                hash.put(num,2);
            }else {
                hash.put(num,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if(entry.getValue()==1){return entry.getKey();}
        }
        return -1;
    }
}
