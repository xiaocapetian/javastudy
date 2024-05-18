package leetcode700;

import java.util.HashSet;

/**
 * 自己摸索出来的,就是速度慢了,
 * 用了两个visited
 * visitedFromInit代表从头开始,直接把某元素放进setA中(当然也可以用两个set有没有来判断,但是更慢了
 * visited代表两个节点之间的线是不是访问过
 * 也就是不能单独用visited[]来表达有没有访问过3,而是表大有没有从2访问过3
 *
 */
public class l785 {
    boolean[] visitedFromInit;
    boolean[][] visited;
    HashSet<Integer> setA;
    HashSet<Integer> setB;
    /**
     *判断二分图
     * @param graph 其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。
     *              graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        visitedFromInit = new boolean[graph.length];
        visited = new boolean[graph.length][graph.length];
        setA=new HashSet<>();
        setB=new HashSet<>();
        for (int i = 0; i < graph.length; i++) {

            //if(!setA.contains(i)&&!setB.contains(i)){
            if(!visitedFromInit[i]){
                boolean b = fenpei(i,setA,graph);
                System.out.println(setA);
                System.out.println(setB);
                if(!b)return false;
            }
        }
        return true;
    }

    private boolean fenpei(int i,HashSet<Integer> set,int[][] graph) {
        //if(visited[i]){return true;}
        visitedFromInit[i] = true;
        set.add(i);
        if(anotherSet(set).contains(i)){
            return false;
        }

        for (int j : graph[i]) {
            if(!visited[i][j]){
                visited[i][j] = true;
                boolean b = fenpei(j, anotherSet(set), graph);
                if(!b)return false;
            }

        }
        return true;
    }
    private HashSet<Integer> anotherSet(HashSet<Integer> set){
        if(set==setA)return setB;
        else return setA;
    }

}
