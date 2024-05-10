package leetcode200;

import java.util.ArrayList;
import java.util.List;

public class l207v1 {
//使用和l210一样的思路
    //Stack<Integer> stack;
    List<List<Integer>> edges;
    boolean vaild;
    int[] visited;//==0没用访问,1,正在访问,2访问完成
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //stack = new Stack<>();
        edges = new ArrayList<>();
        vaild = true;
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        //学prerequisite[0]前先学prerequisite[1]
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < edges.size()&&vaild==true; i++) {
            if(visited[i]==0){dfs(i);}
        }
        return vaild;
    }
    private void dfs(int u){
        //System.out.println("dfs");
        //标记为搜索中
        visited[u]=1;
        List<Integer> houji = edges.get(u);
        for (Integer houjiKe : houji) {
            if(visited[houjiKe]==0){
                dfs(houjiKe);
            }
            if(visited[houjiKe]==1){
                //如果dfs到了==1的搜索中说明出现了什么严重问题呀?-----说明找到环了!!!
                //System.out.println("找到环了");
                vaild =false;
                return;}
            if(visited[houjiKe]==2){

            }
        }
        //记得!!这里要标记为已完成!!
        visited[u]=2;
    }
}
