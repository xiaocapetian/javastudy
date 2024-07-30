package leetcode700;

import java.util.LinkedList;
import java.util.Queue;

public class l713 {
    /**
     * 又想了一个版本,成功!  (大声喊出4个字,滑动窗口!!!)
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = 0, res = 0, chengji =1;
        for(; right < nums.length; right++) {
            //System.out.println("chengji = " + chengji+"left="+left+"right="+right);
            chengji *= nums[right];
            while(left<=right&&chengji >= k) {  /*[难点]left<=right如果想等也是有意义的*/
                chengji/=nums[left];
                left++;
            }
            res += right-left+1;
        }
        return res;
    }
    /**
     * 正确但超时  用了一个队列
     */
    public int numSubarrayProductLessThanKV1(int[] nums, int k) {

        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //System.out.println(queue);
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer poll = queue.poll();
                if(poll*nums[i]<k){
                    res++;
                    queue.offer(poll*nums[i]);
                }
            }
            if(nums[i]<k){
                res++;
                queue.offer(nums[i]);
            }
        }
        return res;

    }
}
