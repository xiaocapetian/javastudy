package leetcode400;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class l451 {
    //像这种需要排序的map一定要想到优先队列啊!!!
    //字符转asc码  (int)entry.getKey()
    // asc码转字符  (char)pqarr[1]

    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        //System.out.println(map);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> {if(o1[0]!=o2[0]){return o2[0]-o1[0];}return o1[1]-o2[1];});
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            //System.out.println("entry.getValue()"+entry.getValue()+"(int)entry.getKey()"+(int)entry.getKey());
            pq.add(new int[]{entry.getValue(),(int)entry.getKey()});  /*字符转asc码*/
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] pqarr = pq.poll();
            //System.out.println(Arrays.toString(pqarr));
            for (int i = 0;i<pqarr[0];i++){   //[易错]:这里别反了啊
                sb.append((char)pqarr[1]);   /*asc码转字符*/
            }

        }
        return sb.toString();
    }
}
