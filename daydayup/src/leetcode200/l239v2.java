package leetcode200;

import java.util.PriorityQueue;

/**
 * 优先队列,(int[]要保存值和索引的)
 */
public class l239v2 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0]!=o2[0])return o2[0]-o1[0];
            return o1[1]-o2[1];
        });
        //int[0] 值,int[1]下标
        for(int i = 0;i<k;i++){
            int[] arr = new int[]{nums[i],i};
            pq.add(arr);
        }
        int[] res = new int[nums.length-k+1];
        res[0] = pq.peek()[0];
        for(int i = k;i<nums.length;i++){
            int[] arr = new int[]{nums[i],i};
            pq.add(arr);
            while (pq.peek()[1]<=i-k){/*[易错]👈边界条件*/
                pq.poll();
            }
            res[i-k+1] = pq.peek()[0];
        }
        return res;
    }
}
