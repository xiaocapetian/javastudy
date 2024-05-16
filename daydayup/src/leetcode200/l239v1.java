package leetcode200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调队列,不用自己定义一个类啦,其他和v0是一样的
 */
public class l239v1 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();

        //单调队列，是单减的，且按照滑窗次序，队列里最多放k个元素
        for(int i = 0;i<k;i++){
            while (!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.pollLast();
            }
            deque.add(nums[i]);
        }
        res[0]= deque.peekFirst();
        for(int i = k;i<nums.length;i++){
//            if(deque.size()>k-1){
//                deque.pollFirst();
//            }
            /*[易错]这里弹出元素不能按照size()了!得对照原数组看看单调队列里的和原数组的是不是一致*/
            if(nums[i-k]==deque.peekFirst()){
                deque.pollFirst();
            }
            while (!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.pollLast();
            }
            deque.add(nums[i]);

            res[i-k+1] = deque.peekFirst();
        }
        return res;
    }
}
