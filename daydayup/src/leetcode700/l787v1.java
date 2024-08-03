package leetcode700;

import java.util.ArrayList;
import java.util.List;
//如同l743v3,我改进了存储方式,但是还是超时了
public class l787v1 {
    int Dst;
    int K;
    int Price = Integer.MAX_VALUE;
    /**
     *是对的,但是超时了
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
        //用了一个flyMap来存
        int[][] flyMap=new int[n][n];
        boolean[] visited = new boolean[n];
        visited[src]=true;
        for (int i = 0; i < flights.length; i++) {

            flyMap[flights[i][0]][flights[i][1]]=flights[i][2];
        }
        List<Integer> start = new ArrayList<>();
        start.add(src);
        findpath(flyMap,start,0,visited,0);

        return Price==Integer.MAX_VALUE?-1:Price;
    }
    private void findpath(int[][] flylist,List<Integer> path,int nowprice,boolean[] visited,int step ){
        System.out.println(path);
        System.out.println("nowprice"+nowprice);
        //价格超了/步数超了
        if(step>K+1||nowprice>=Price){return;}/*[易错]*/
        int from = path.get(path.size()-1);
        //如果我已经到了目的地
        if(from==Dst){
            if(nowprice<Price ){
                Price = nowprice;
            }
            return;
        }
        for (int i = 0; i < flylist[from].length; i++) {
            //只要2个之间有桥,且没访问过
            if(flylist[from][i]!=0&&!visited[i]){
                visited[i] = true;
                path.add(i);
                findpath(flylist,path,nowprice+flylist[from][i],visited,step+1);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }

    }
}
