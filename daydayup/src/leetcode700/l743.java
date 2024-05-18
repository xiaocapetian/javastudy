package leetcode700;
//v1,v2,v3都是自己写的,一点一点变快,但是都不如v0这个!!
/**
 * dijkstra 算法
 * 本题就是求最短路，最短路是图论中的经典问题即：给出一个有向图，一个起点，一个终点，问起点到终点的最短路径。
   最短路算法中的 dijkstra 算法:
   在有权图（权值非负数）中求从起点到其他节点的最短路径算法。
 *

 */
public class l743 {

    /**   试试自己写那玩意 dijkstra
     * 不搞什么深度优先搜索,每次只搜到下一格
     * 一个for循环但是和循环的i无关,  每轮访问谁?   要找一个同时符合:1.没访问过,2.到出发点距离最小的点pp
     * 怎么访问? 对这个点pp访问他能到哪
     *
     * @param times 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
     * @param n 有 n 个网络节点，标记为 1 到 n。
     * @param k 从某个节点 K 发出一个信号。
     * @return 需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] canVisit = new int[n + 1];
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
        //====================
        canVisit[k] = 0;
        boolean[] visited = new boolean[n+1];
        for (int i = 0;i<n;i++){
            //System.out.println("前"+Arrays.toString(visited));
            //要找一个同时符合:1.没访问过,2.canVisit[k]最小的点p1.最小距离是distance
            int p1 = 0;
            int distance = Integer.MAX_VALUE;
            for (int j = 1;j<n+1;j++){                             //[注意]那这里j的范围就得从1开始算了
                if(!visited[j]&&distance> canVisit[j]){
                    p1 = j;
                    distance = canVisit[j];
                }
            }
            //现在p1访问过了
            visited[p1] =true;
            //怎么访问?
            for (int j = 0; j < map[p1].length; j++) {
                if(map[p1][j]!=Integer.MAX_VALUE//只要p1和j点有路且
                        &&map[p1][j]+ canVisit[p1]< canVisit[j]){//到p1的路+p1到j的路<到j的路
                    canVisit[j] = map[p1][j]+ canVisit[p1];
                }
            }
            //System.out.println("后"+Arrays.toString(visited));
        }
        int res = 0;
        for (int i : canVisit) {
            if(i>res){
                res=i;
            }
        }
//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println(Arrays.toString(canVisit));
        return res==Integer.MAX_VALUE?-1:res;
    }
}
/* * 作者：代码随想录
 * 链接：https://leetcode.cn/problems/network-delay-time/solutions/2659415/dijkstra-po-su-yu-dui-you-hua-dai-ma-sui-kp1q/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */