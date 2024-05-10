package leetcode400;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class l496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                Integer small = nums2[stack.pop()];
                map.put(small,nums2[i]);
            }
            stack.push(i);
        }
        for(int i = 0; i < nums1.length; i++){
            //if(map.containsKey(nums1[i])){res[i] = map.get(nums1[i]);}
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;

    }
}
