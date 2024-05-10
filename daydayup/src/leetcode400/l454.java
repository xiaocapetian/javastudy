package leetcode400;

import java.util.HashMap;
import java.util.Map;

public class l454 {
    //这道题的难点在于想到4个数组,要两两组合
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int res = 0;
        Map<Integer,Integer> hash = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                hash.put(k+i,hash.getOrDefault(k+i,0)+1);
                //不要像下面那样写了，用hash.getOrDefault(),输入一个想查的键,一个默认值,
                //键存在返回值,不存在返回默认值(我设为0),然后把结果+1,put回去

                //if (hash.containsKey(k + i)) {
                    //int c = hash.get(nums1[i]+nums2[j]);
                    //hash.put(nums1[i]+nums2[j],c+1);
                //} else {
                    //hash.put(k + i, 1);
                //}
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int cd = -i - j;
                if(hash.containsKey(cd)){
                    res += hash.get(cd);
                }
            }
        }
        return res;
    }
}
