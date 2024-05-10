package leetcode700;


public class l743v3 {
    private int[] canVisit;
    /**   不要map了,建一个二维数组map更快了,终于又快了一点130ms,但是还是超级慢的
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
        int[][] map = new int[n+1][n+1];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j]=Integer.MAX_VALUE;
            }
        }
        //map[i][j]代表i到j的距离
        for (int i = 0; i < times.length; i++) {
            map[times[i][0]][times[i][1]] = times[i][2];
        }

        visit(map,k,0);

        int maxres = 0;
        for (int i = 1; i < canVisit.length; i++) {
            if(canVisit[i]==Integer.MAX_VALUE){return -1;}
            maxres = Math.max(canVisit[i],maxres);
        }
        return maxres;
    }

    private void visit(int[][] map,int k,int cost) {
        canVisit[k] = cost;
        for (int j = 0; j < map.length; j++) {
            if(map[k][j]!=Integer.MAX_VALUE&&cost+map[k][j]<canVisit[j]){
                visit(map,j,cost+map[k][j]);
            }
        }

    }

}
