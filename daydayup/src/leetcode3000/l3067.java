package leetcode3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己写了超长的时间，超级复杂，是对的，但是超时了，我抄nm
 * 我的问题在哪，我把问题复杂化了。题目中规定了这是一个带权树，不是图，双向边的数量为n-1
 * 那我把问题想复杂了，既然是树， a肯定能到b,必然只有一条路到b
 */
public class l3067 {
    /**
     * 给你一棵无根带权树，树中总共有 n 个节点，分别表示 n 个服务器，服务器从 0 到 n - 1 编号。
     * @param edges 同时给你一个数组 edges ，其中 edges[i] = [ai, bi, weighti] 表示节点 ai 和 bi 之间有一条双向边，边的权值为 weighti 。
     * @param signalSpeed 再给你一个整数 signalSpeed 。
     * @return 请你返回一个长度为 n 的整数数组 count ，其中 count[i] 表示通过服务器 i 可连接 的服务器对的 数目 。
     */
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {

        int len = edges.length+1;
        //已知 edges.length = n-1
        int[] res = new int[len];
        //List<int[]>[] net = new ArrayList[edges.length+1];
        //用一个二维数组来表示带权树网络
        int[][] net = new int[len][len];
        for(int[] edge : edges) {
            net[edge[0]][edge[1]] = edge[2];
            net[edge[1]][edge[0]] = edge[2];
        }
        /*
         * 创建一个二维数组，每个元素都是一个 List<Integer> 的方法：
         * 由于 Java 不允许直接创建泛型数组（例如 new ArrayList<Integer>[len][len] 会导致编译错误），需要先创建一个普通的二维数组，
         * 然后手动初始化每个元素。可以使用 ArrayList<Integer> 实现。
         */

        for (int i = 0; i < len; i++) {
            //对于一个起点和终点，记录所有到终点的方法（包括途径点和路程）
            // 创建一个普通的二维数组
            //@SuppressWarnings("unchecked")
            //针对起点i ,写一个map
            //作为一个数组，其中[k]索引下,为终点是num,List<List<Integer>> 外层代表通向k的多种路径,内层代表每一种路径经过的点
            List<List<Integer>>[] map = new ArrayList[len];
            for (int i1 = 0; i1 < map.length; i1++) {
                map[i1] = new ArrayList<>();
            }
            //j就是终点
            for(int j = 0; j < len; j++) {
                //保证了i！=j
                if(i!=j){
                    dfs(i,j,net,new boolean[edges.length+1],0,new ArrayList<>(),signalSpeed,map);
                }

            }
            //System.out.println("=============");
            //System.out.println("起点i = "+i);
            // for (int i1 = 0; i1 < map.length; i1++) {
            //     System.out.println("终点i1 = "+i1);

            //     for (int i2 = 0; i2 < map[i1].size(); i2++) {
            //         System.out.println(map[i1].get(i2));
            //     }
            // }
            //             System.out.println("=============");
            res[i] = 0;
            //要求：从 c 到 b 的路径与从 c 到 a 的路径没有任何公共边。
            for(int j = 0; j < len; j++) {
                for(int k = j+1; k < len; k++) {
                    if(j==i||k==i)continue;
                    //System.out.println("j="+j+",k="+k);
                    List<List<Integer>> listj = map[j];
                    List<List<Integer>> listk = map[k];
                    //System.out.println("listj = ");
                    // for (int i1 = 0; i1 < listj.size(); i1++) {
                    //     System.out.println(listj.get(i1));
                    // }
                    // System.out.println("listj = ");
                    // for (int i1 = 0; i1 < listk.size(); i1++) {
                    //     System.out.println(listk.get(i1));
                    // }
                    if (judge(listj,listk)) {
                        res[i]++;
                    }
                }
            }

        }
        return res;
    }
    private boolean judge (List<List<Integer>> listj,List<List<Integer>> listk){

        for (int i = 0; i < listj.size(); i++) {
            for(int j = 0; j < listk.size(); j++) {
                //对于两天路径，判断有没有交集
                List<Integer> list1 = listj.get(i);
                List<Integer> list2 = listk.get(j);
                boolean flag = true;
                for (int i1 = 0; i1 < list2.size(); i1++) {
                    if(list1.contains(list2.get(i1))) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(int now,int end, int[][] net,boolean[] vidited,int cost,List<Integer> path,int signalSpeed,List<List<Integer>>[] map) {

        if(now==end){
            if(cost%signalSpeed==0){
                List<Integer> newPath = new ArrayList<>(path);
                //newPath.remove(0);
                map[end].add(newPath);
            }
            return;
        }
        vidited[now] = true;

        for(int i = 0;i<net.length;i++){
            //如果有此点开始的，且下一点没访问过的，就可以往下访问
            //遍历net[now][]这一行
            if(net[now][i]!=0 && !vidited[i]){
                path.add(i);
                dfs(i,end,net,vidited,cost+net[now][i],path,signalSpeed,map);
                path.remove(path.size()-1);
            }
        }

    }
}
