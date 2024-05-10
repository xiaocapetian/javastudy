package leetcode1000;

import java.util.PriorityQueue;

/**
 * hr说的感觉也不一定简单啊
 */
public class l1705v1 {
    public int eatenApples(int[] apples, int[] days) {
        int num=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            //if()
            return o1[1]-o2[1];});
        int maxday = 0;
        for (int i = 0; i < apples.length; i++) {
            for (int j = 0; j < apples[i]; j++) {
                int[] arr=new int[]{i+1,days[i]+i};//哪天获得的,持续到哪天
                //pq.add(days[i]+i);
                maxday = Math.max(maxday,days[i]+i);
            }
        }
        for (int i = 0; i < maxday; i++) {
            //if()
        }

        return num;
    }
}
