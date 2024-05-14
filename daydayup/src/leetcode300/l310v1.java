package leetcode300;

import java.util.*;

public class l310v1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1){res.add(0);return res;}
        List<List<Integer>> map = new ArrayList<>();
        //1...n-1
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        //看好了,出度表是一个单独的int[],存关系表是一个List就行了,把索引作为下标
        int[] chudu = new int[n];
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
            //双向的
            chudu[edges[i][0]]++;
            chudu[edges[i][1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < chudu.length; i++) {
            if(chudu[i]==1){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Integer poll = queue.poll();
                List<Integer> houdais = map.get(poll);
                for (Integer houdai : houdais) {
                    chudu[houdai]--;
                    if(chudu[houdai]==1){
                        queue.add(houdai);
                    }
                }
                res.add(poll);
            }
        }
        return res;
    }
}
