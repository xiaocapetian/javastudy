package leetcode3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 直接抄的答案,最后根据思路修改了自己写的v3
 */
public class l3067v2 {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int len = edges.length + 1;
        List<int[]>[] graph = new ArrayList[len];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1],edge[2]});
            graph[edge[1]].add(new int[]{edge[0],edge[2]});
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            //源点
            if (graph[i].size() == 1) {
                continue;
            }
            int sum = 0;
            for (int[] e : graph[i]) {
                int cnt = dfs(e[0], i, e[1], graph, signalSpeed);
                res[i] += cnt * sum;
                sum += cnt;
            }
        }
        return res;
    }

    private int dfs(int now, int fa, int sum, List<int[]>[] graph, int signalSpeed) {
        int cnt = sum % signalSpeed == 0 ? 1 : 0;
        for (int[] child : graph[now]) {
            int y = child[0];
            if (y != fa) {
                cnt += dfs(y, now, sum + child[1], graph, signalSpeed);
            }
        }
        return cnt;
    }

//    作者：灵茶山艾府
//    链接：https://leetcode.cn/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/solutions/2664330/mei-ju-gen-dfs-cheng-fa-yuan-li-pythonja-ivw5/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
