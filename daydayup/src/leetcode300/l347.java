package leetcode300;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class l347 {
    /**
     * 来,自己写一遍!
     * 写出来啦!我真棒!
     * */
    public int[] topKFrequent(int[] nums, int k) {
        //先建一个map存起来
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //优先队列,可自定义排序规则
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        //遍历map,怎么写要知道
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];//优先队列的poll会按顺序噢!
        }
        return res;
    }



    /**下文是抄的
     * */
    public int[] topKFrequent2(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();////key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair2[1]-pair1[1]);

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new int[] {entry.getKey(),entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=pq.poll()[0];
        }
        return res;
    }
}
