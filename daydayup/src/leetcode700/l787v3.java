package leetcode700;

import java.util.Arrays;

/**
 * 需要注意的是，在遍历所有的“点对/边”进行松弛操作前，需要先对 distdistdist 进行备份，
 * 否则会出现「本次松弛操作所使用到的边，也是在同一次迭代所更新的」，从而不满足边数限制的要求。
 * 举个 🌰，例如本次松弛操作使用了从 a 到 b 的当前最短距离来更新 dist[b]，直接使用 dist[a] 的话，
 * 不能确保 dist[a] 不是在同一次迭代中所更新，如果 dist[a] 是同一次迭代所更新的话，那么使用的边数将会大于 k 条。
 * 因此在每次迭代开始前，我们都应该对 dist进行备份，在迭代时使用备份来进行松弛操作。
 *
 * 作者：宫水三叶
 * 链接：https://leetcode.cn/problems/cheapest-flights-within-k-stops/solutions/955290/gong-shui-san-xie-xiang-jie-bellman-ford-dc94/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class l787v3 {
    int N;
    int M;

    public static void main(String[] args) {
        l787v3 s = new l787v3();
        int[][] flights = {{0,1,1},{1,2,1},{2,0,1},{1,3,6},{2,3,2}};
        s.findCheapestPrice(4,flights,0,3,1);
        System.out.println("=========");
        s.findCheapestPriceWithoutClone(4,flights,0,3,1);
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        k = k+1;//k个中转就是k+1个边,
        N = n;
        M = flights.length;
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        //最初的Bellman-Ford中,范围是 i<n-1
        //for(int i = 0;i<n-1;i++){//不准超过k条边
        //而这里改成了k
        /*有一个思路:n个节点,n-1是什么,不就是在不重复的情况下,图中可能出现的一条最长的路径嘛!
        * 那现在允许的最长路径不是n-1条边了,
        * 而最长允许k条边*/
        for(int i = 0;i<k;i++){//不准超过k条边
            System.out.println("每轮之前:"+Arrays.toString(distance));
            /*[重难点]这里克隆一下*/ //否则会出现「本次松弛操作所使用到的边，也是在同一次迭代所更新的」，从而不满足边数限制的要求。
            int[] distanceClone = distance.clone();
            System.out.println("~~~~~");
            for (int j = 0; j < flights.length; j++) {
                int from = flights[j][0];
                int to = flights[j][1];
                int price = flights[j][2];
                if(distanceClone[from]!=Integer.MAX_VALUE
                        &&distance[from]+price<distance[to]){//
                    //distance[to]=distance[from]+price;
                    distance[to]=distanceClone[from]+price;
                }
                System.out.println(Arrays.toString(distance));
            }
        }
        return distance[dst]!=Integer.MAX_VALUE?distance[dst]:-1;
    }
    public int findCheapestPriceWithoutClone(int n, int[][] flights, int src, int dst, int k) {

        k = k+1;//k个中转就是k+1个边,
        N = n;
        M = flights.length;
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for(int i = 0;i<k;i++){//不准超过k条边
            System.out.println("~~~~~");
            //int[] distanceClone = distance.clone();
            for (int j = 0; j < flights.length; j++) {
                int from = flights[j][0];
                int to = flights[j][1];
                int price = flights[j][2];
                if(distance[from]!=Integer.MAX_VALUE
                        //distanceClone[from]!=Integer.MAX_VALUE
                        &&distance[from]+price<distance[to]){//
                    distance[to]=distance[from]+price;
                    //istance[to]=distanceClone[from]+price;
                }
                System.out.println(Arrays.toString(distance));
            }
        }
        return distance[dst]!=Integer.MAX_VALUE?distance[dst]:-1;
    }
}
