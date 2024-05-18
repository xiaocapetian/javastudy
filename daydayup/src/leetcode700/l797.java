package leetcode700;

import java.util.ArrayList;
import java.util.List;

public class l797 {
    /**
     *最普通的回溯,不用去重或者跳过啥的
     * @param graph
     * @return 请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<Integer> start = new ArrayList<>();
        start.add(0);
        findpath(graph,start);
        return res;
    }

    private void findpath(int[][] graph,List<Integer> path) {
        //path.add(now);
        int now = path.get(path.size()-1);
        if( now==graph.length-1){
            List<Integer> tmp = new ArrayList<>(path);
            res.add(tmp);
        }
        for (int i = 0; i < graph[now].length; i++) {
            path.add(graph[now][i]);
            findpath(graph,path);
            path.remove(path.size()-1);
        }
    }
}
