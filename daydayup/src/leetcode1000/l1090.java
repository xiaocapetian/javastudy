package leetcode1000;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class l1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {

//就是个排序嘛,很普通的题
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[0] - o1[0];
        });

        for(int i= 0;i<values.length;i++){
            int[] a = new int[]{values[i],labels[i]};
            pq.add(a);
        }
        //
        int count = 0;
        int res=0;
        Map<Integer,Integer> map = new HashMap<>();
        while (!pq.isEmpty()&&count<numWanted){
            int[] poll = pq.poll();
            Integer labelnum = map.getOrDefault(poll[1], 0);
            if(labelnum==useLimit){
                continue;
            }
            else {
                map.put(poll[1],labelnum+1);
                count++;
                res+=poll[0];
            }
        }
        return res;
    }
}
