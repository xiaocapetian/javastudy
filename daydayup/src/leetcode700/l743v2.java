package leetcode700;

import java.util.*;

public class l743v2 {
    private int[] canVisit;
    /**   建了一个map,map哈希查比遍历链表快,终于没有超时,但是还是超级慢的  330ms
     *
     * @param times 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
     * @param n 有 n 个网络节点，标记为 1 到 n。
     * @param k 从某个节点 K 发出一个信号。
     * @return 需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        canVisit = new int[n+1];
        for (int i = 1; i < canVisit.length; i++) {
            canVisit[i] = Integer.MAX_VALUE;
        }
        //
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            List<int[]> list = map.getOrDefault(times[i][0], new ArrayList<>());
            int[] arr = new int[2];
            arr[0]=times[i][1];//目的地
            arr[1]=times[i][2];//花费
            list.add(arr);
            map.put(times[i][0],list);
        }

        visit(map,k,0);
//        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
//            System.out.println(entry.getKey()+"value");
//            for (int[] ints : entry.getValue()) {
//                System.out.println(Arrays.toString(ints));
//            }
//        }
//        System.out.println(Arrays.toString(canVisit));
        int maxres = 0;
        for (int i = 1; i < canVisit.length; i++) {
            if(canVisit[i]==Integer.MAX_VALUE){return -1;}
            maxres = Math.max(canVisit[i],maxres);
        }
        return maxres;
    }

    private void visit(Map<Integer, List<int[]>> map,int k,int cost) {
        canVisit[k] = cost;
        if(map.containsKey(k)){
            for (int[] arr : map.get(k)) {
                if(cost+arr[1]<canVisit[arr[0]]){
                    visit(map,arr[0],cost+arr[1]);
                }

            }
        }

    }
}
