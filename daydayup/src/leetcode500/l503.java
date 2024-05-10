package leetcode500;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class l503 {
    public int[] nextGreaterElements(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {res[i]=-1;}
        for (int i = 0; i < 2*nums.length; i++) {
            //int iFix = i >= nums.length ? i - nums.length : i;
            int iFix =i%nums.length;//用了取余数,遍历多少圈都不怕!
            while(!stack.isEmpty()&&nums[iFix]>nums[stack.peek()]){
                Integer small = stack.pop();
                res[small] = nums[iFix];
            }
            stack.push(iFix);
        }
        return res;
    }
}
