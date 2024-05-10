package leetcode200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*递归深度优先,队列广度优先*/
public class l210 {
    //那么这里写的是深度优先
    Stack<Integer> stack;
    List<List<Integer>> edges;
    boolean vaild;
    int[] visited;//==0没用访问,1,正在访问,2访问完成
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        stack = new Stack<>();
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
        if(vaild){
            int[] res = new int[numCourses];
            for (int i = 0; i < res.length; i++) {
                res[i] = stack.pop();
            }
            /*注意!!赋值不能这样写👇!!!!*/
//            for (int re : res) {
//                re = stack.pop();
//            }
            return res;
        }else {return new int[0];}
    }
    private void dfs(int u){
        //System.out.println("dfs");
        //标记为搜索中
        visited[u]=1;
        List<Integer> houji = edges.get(u);
        for (Integer houjiKe : houji) {
            if(visited[houjiKe]==0){//如果碰上了==0,说明之前每搜过,那就接着搜它
                dfs(houjiKe);
            }
            if(visited[houjiKe]==1){
                //如果dfs到了==1的搜索中说明出现了什么严重问题呀?-----说明找到环了!!!
                System.out.println("找到环了");
                vaild =false;
                return;}
            if(visited[houjiKe]==2){
//碰上了==2说明已经搜过了,不必管它
            }
        }
        //记得!!这里要标记为已完成!!
        visited[u]=2;
        stack.push(u);

    }
}
