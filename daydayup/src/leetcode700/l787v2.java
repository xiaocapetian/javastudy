package leetcode700;

import java.util.Arrays;

/**
 * 最短路算法中的 dijkstra 算法:
 * 但是这题不可以啊!为什么?因为限制了要边不能超过k
 * 本题属于 有限制的最短路径:「限制最多不超过 k+1k + 1k+1 条边」
 *
 * 即使我定义了这个数组也不可以,int[] zhongzhuan =new int[n];
 */
public class l787v2 {
    public static void main(String[] args) {
        l787v2 s = new l787v2();
        int[][] flights = {
//                {4, 1, 1},
//                {1, 2, 3},
//                {0, 3, 2},
//                {0, 4, 10},
//                {3, 1, 1},
//                {1, 4, 3}
                {0,2, 1},
                {0,1, 2},
                {1,2, -2},
                {2,3, 1},
        };
        s.findCheapestPrice(4,flights,0,3,20);
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] flylist=new int[n][n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < flights.length; i++) {
            flylist[flights[i][0]][flights[i][1]]= flights[i][2];
        }


        int[] distance =new int[n];
        //距离设成无穷大
        for (int i = 0; i < distance.length; i++) {
            distance[i]=Integer.MAX_VALUE;
        }

        distance[src] = 0;
        //现在到i要中转几次
        int[] zhongzhuan =new int[n];
        //visited[src]=true;
        for(int i = 0 ;i<n;i++){
            //找一个距离最小,且没有访问过的点p1
            int mindistance = Integer.MAX_VALUE;
            int p1=0;
            for (int j = 0; j < distance.length; j++) {
                if(distance[j]<mindistance&&!visited[j]){
                    p1 = j;
                    mindistance = distance[j];
                }
            }
            if(distance[p1]==Integer.MAX_VALUE){continue;}////
            visited[p1] = true;
            for (int j = 0; j < flylist[p1].length; j++) {
                if(flylist[p1][j]!=0&&flylist[p1][j]+distance[p1]<distance[j]&&zhongzhuan[p1]+1<=k+1){
                    distance[j]=flylist[p1][j]+distance[p1];
                    zhongzhuan[j] = zhongzhuan[p1]+1;
                }
            }
            System.out.println(Arrays.toString(distance));
        }
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
    }
}
