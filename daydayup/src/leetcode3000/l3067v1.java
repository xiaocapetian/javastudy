package leetcode3000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据答案的思路写的,是对的.怎么又超时啊啊啊啊啊啊啊啊
 * v1我用的是map, v3用int[],v1会比v3慢
 * 当去除了path,用pre时,也能通过,但是比v3慢
 */
public class l3067v1 {
    /**
     * 给你一棵无根带权树，树中总共有 n 个节点，分别表示 n 个服务器，服务器从 0 到 n - 1 编号。
     * @param edges 同时给你一个数组 edges ，其中 edges[i] = [ai, bi, weighti] 表示节点 ai 和 bi 之间有一条双向边，边的权值为 weighti 。
     * @param signalSpeed 再给你一个整数 signalSpeed 。
     * @return 请你返回一个长度为 n 的整数数组 count ，其中 count[i] 表示通过服务器 i 可连接 的服务器对的 数目 。
     */
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {

        //对于一个节点m ,以它为头节点，如果他只用一个邻居，
        //那它到哪个点的距离不都得通过这一个邻居嘛？必然是0啊
        //那假设它拥有3个邻居   a b c
        //源点m到a+a到假设有3个点的举例符合要求（signalSpeed）的倍数
        //源点m到b+ b假设有4个点的举例符合要求
        //源点m到c+ c假设有5个点的举例符合要求
        //那么答案是 4*3  +  5*（3+4） 只考虑右半部分哦
        int len = edges.length+1;
        Map<Integer,Integer>[] graph = new HashMap[len];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashMap<>();
        }
//        for (Map<Integer, Integer> map : graph) {
//            map = new HashMap<>();
//        }
        for (int[] edge : edges) {
            graph[edge[0]].put(edge[1],edge[2]);
            graph[edge[1]].put(edge[0],edge[2]);
        }
        for (Map<Integer, Integer> integerMap : graph) {
            System.out.println(integerMap);
        }
        int[] res = new int[len];
        for(int i = 0;i<len;i++){
            System.out.println("以第"+i+"个点为源点=================================");
            Map<Integer, Integer> map = graph[i];
            int childSize = map.size();
            int sum = 0;
            System.out.println("i="+i+",childSize="+childSize);
            System.out.println(map);
            if(childSize!=1){
                int[] childarr = new int[childSize];
                int[] childSumarr = new int[childSize];
                int count = 0;
                for (Integer key : map.keySet()) {
                    System.out.println("访问的邻居是第key="+key+",value="+map.get(key));
                    List<Integer> validPoint = new ArrayList<>();
                    List<Integer> path = new ArrayList<>();
                    path.add(i);
                    dfs(key,map.get(key),i,signalSpeed,validPoint,graph);
                    childarr[count] = validPoint.size();
                    System.out.println("childarr[count]"+childarr[count]);
                    if(count>0){
                        childSumarr[count] =childarr[count-1]+childSumarr[count-1];
                        sum+=childarr[count]*childSumarr[count];
                    }
                    /*[易错]这里写👆时,一定要像下面👇那样把给列出来啊!列出来就清晰了*/
//以3 4 5为例,
//  childarr[0] =3   childarr[1] =4 childarr[2] =5
// childSumarr[0] =0, childSumarr[0] = 3, childSumarr[0] = 3+4
                    System.out.println("childSumarr[count]"+childSumarr[count]);

                    count++;

                }

            }


            res[i] = sum;
        }
        return res;
    }
    private void dfs(int now, int cost,int pre,int signalSpeed,List<Integer> validPoint,Map<Integer,Integer>[] graph) {

        System.out.println("now="+now+",cost="+cost+",signalSpeed="+signalSpeed);
        if(cost%signalSpeed==0){
            validPoint.add(now);
            System.out.println("添加了"+now);
            //return;
        }
        Map<Integer, Integer> map = graph[now];
        for (Integer key : map.keySet()) {

            if(key!=pre){
                System.out.println("没有,可添加");
                dfs(key,cost+map.get(key),now,signalSpeed,validPoint,graph);
            }

        }
    }

    private void dfs1(int now, int cost,int signalSpeed,List<Integer> validPoint,Map<Integer,Integer>[] graph,List<Integer> path) {
        path.add(now);
        System.out.println("now="+now+",cost="+cost+",signalSpeed="+signalSpeed);
        if(cost%signalSpeed==0){
            validPoint.add(now);
            System.out.println("添加了"+now);
            //return;
        }
        Map<Integer, Integer> map = graph[now];
        for (Integer key : map.keySet()) {
            System.out.println("path="+path+",key="+key);
            if(!path.contains(key)){
                System.out.println("没有,可添加");
                dfs1(key,cost+map.get(key),signalSpeed,validPoint,graph,path);
            }

        }
    }
}
