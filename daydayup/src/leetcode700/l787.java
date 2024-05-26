package leetcode700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//l743和l787
public class l787 {
    int Dst;
    int K;
    int Price = Integer.MAX_VALUE;

    /**
     *是对的,但是超时了  这道题我第一反应就是回溯啊!
     *
     * @param n 有 n 个城市通过一些航班连接。
     * @param flights 给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
     * @param src 出发城市 src
     * @param dst 目的地 dst
     * @param k 找到出一条最多经过 k 站中转的路线
     * @return 使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Dst = dst;
        K =k;
        //造了一个很复杂的结构来存,其实可以直接用v2的int[][],没必要这么复杂
        List<int[]>[] flylist = new ArrayList[n];
        for (int i = 0; i < flylist.length; i++) {
            flylist[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n];
        visited[src]=true;
        for (int i = 0; i < flights.length; i++) {

            flylist[flights[i][0]].add(new int[]{flights[i][1],flights[i][2]});
        }
        List<Integer> start = new ArrayList<>();
        start.add(src);
        findpath(flylist,start,0,visited,0);
        for (int i = 0; i < flylist.length; i++) {
            for (int j = 0; j < flylist[i].size(); j++) {
                System.out.println(Arrays.toString(flylist[i].get(j)));
            }
            System.out.println("======");
        }

        return Price==Integer.MAX_VALUE?-1:Price;
    }
    private void findpath(List<int[]>[] flylist,List<Integer> path,int nowprice,boolean[] visited,int step ){
        System.out.println(path);
        System.out.println("nowprice"+nowprice);
        if(step>K+1||nowprice>=Price){return;}/*[易错]*/
        int from = path.get(path.size()-1);
        if(from==Dst){
            if(nowprice<Price ){

                Price = nowprice;
                return;
            }
        }

        List<int[]> toList = flylist[from];
        for (int[] to : toList) {
            if(!visited[to[0]]){
                visited[to[0]] = true;
                path.add(to[0]);
                findpath(flylist,path,nowprice+to[1],visited,step+1);
                path.remove(path.size()-1);
                visited[to[0]] = false;
            }

        }

    }
}
