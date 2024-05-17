package leetcode300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 连答案我都看不懂啊,,,,!!!
 * 看完代码之后我就看懂了,原来就是统计"出度"然后就找到最内层了,它要的不就是最内层吗
 * 这就是类似二次叉树的层序遍历,广度优先搜索啊!!
 */
public class l310 {
    /**
     *
     * @param n 给你一棵包含 n 个节点的树，标记为 0 到 n - 1
     * @param edges 给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
     *              其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        /*如果只有一个节点，那么他就是最小高度树*/
        if (n == 1) {
            res.add(0);
            return res;
        }
        /*建立各个节点的出度表*/
        int[] degree = new int[n];
        /*建立图关系，在每个节点的list中存储相连节点*/ //nm看题看仔细啊我抄,明明节点数量1~n-1是确定的
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());  //先放很多空节点过去
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;//出度:应该指的是和该节点连接的节点的数量
            map.get(edge[0]).add(edge[1]);/*添加相邻节点*/
            map.get(edge[1]).add(edge[0]);
        }
        /*建立队列*/
        Queue<Integer> queue = new LinkedList<>();
        /*把所有出度为1的节点，也就是叶子节点入队*/
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        /*循环条件当然是经典的不空判断*/
        while (!queue.isEmpty()) {
            res = new ArrayList<>();/*这个地方注意，我们每层循环都要new一个新的结果集合，
            这样最后保存的就是最终的最小高度树了*/
            int size = queue.size();/*这是每一层的节点的数量*/
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);/*把当前节点加入结果集，不要有疑问，为什么当前只是叶子节点为什么要加入结果集呢?
                因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点，
                这也是很多题解里面所说的剪掉叶子节点的部分，你可以想象一下图，每层遍历完，
                都会把该层（也就是叶子节点层）这一层从队列中移除掉，
                不就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图吗*/
                List<Integer> neighbors = map.get(cur);
                /*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
                 * 把它们的出度都减1，因为当前节点已经不存在了，所以，
                 * 它的相邻节点们就有可能变成叶子节点*/
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        /*如果是叶子节点我们就入队*/
                        queue.offer(neighbor);
                    }
                }
            }
            System.out.println(res);
        }
        return res;/*返回最后一次保存的list*/
    }

//    作者：小鑫
//    链接：https://leetcode.cn/problems/minimum-height-trees/solutions/242910/zui-rong-yi-li-jie-de-bfsfen-xi-jian-dan-zhu-shi-x/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
