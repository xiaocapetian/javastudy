package leetcode1000;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class l1696v1 {
    public int maxResult(int[] nums, int k) {
//从i到(1+1 ~ i+k)不越界
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        //单调队列法
        //Deque<Integer> deque = new LinkedList<>();
        //优先队列法(速度还是比较慢的~)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0]!=o2[0]?o2[0]-o1[0]:o1[1]-o2[1];
        });
        for(int i = 1;i<nums.length;i++){
            //找dp[i-k]~dp[i-1]这个滑动窗口的最大值
            //int[] arr = new int[]{nums[i-1],i-1};
            int[] arr = new int[]{dp[i-1],i-1};/*[易错]👈这里写进去的是dp[i-1],记住啊*/
            pq.add(arr);
            while (pq.peek()[1]<i-k){
                pq.poll();
            }
            int max=pq.peek()[0];

            dp[i] = max+ nums[i];
            System.out.println("i="+i+"max = "+max+"dp[]="+dp[i]);
        }
//System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }
}
