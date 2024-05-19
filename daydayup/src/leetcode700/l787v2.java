package leetcode700;

/**
 * 最短路算法中的 dijkstra 算法:
 */
public class l787v2 {
    public static void main(String[] args) {
        l787v2 s = new l787v2();
        //int[][] flights = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};
        //s.findCheapestPrice(5,flights,2,1,1);

        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        s.findCheapestPrice(4,flights,0,3,1);
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
            for (int j = 0; j < n; j++) {
                if(distance[j]<mindistance&&!visited[j]){
                    p1 = j;
                    mindistance = distance[j];
                }
            }
            if(distance[p1]==Integer.MAX_VALUE){continue;}//这么设计的目的是遇到距离是无穷大的直接跳过

            visited[p1] = true;
            for (int j = 0; j < flylist[p1].length; j++) {
                if(flylist[p1][j]!=0&&flylist[p1][j]+distance[p1]<distance[j]&&zhongzhuan[p1]+1<=k+1){
                    distance[j]=flylist[p1][j]+distance[p1];
                    zhongzhuan[j] = zhongzhuan[p1]+1;
                }
            }

        }
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
    }
}
