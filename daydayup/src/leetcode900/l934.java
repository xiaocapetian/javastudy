package leetcode900;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这题堪称重难题,前半部分用深搜,后半部的用广搜
 * 而且看了下答案,确实是深搜(找第一个岛)+广搜(最短距离)实现
 */
public class l934 {

    int[][] dictions = new int[][]{
            {-1,0},{1,0},{0,-1},{0,1}
    };
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        //第一步,用深搜,发现所有可到达的点
        findLandOne(grid,queue);
        //现在第一座岛变成2了,并且加到队列中
//        for(int i = 0;i<grid.length;i++){
//             System.out.println(Arrays.toString(grid[i]));
//        }
        //第二步,用广搜,找最短路径
        int res = bfs(queue,grid);
        return res;
    }
    //首先找到一个陆地,然后用深搜来发现所有相连的地
    private void findLandOne(int[][] grid,Queue<int[]> queue) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                //一旦发现陆地
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited, queue);
                    return;
                }
            }
        }
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited,Queue<int[]> queue){
        //注意这个写法啊,以后这个是否会dfs的判断(什么合法呀是不是访问过呀)最好在dfs的最开始判断,这样写起来简便多了
        if(!isvalid(grid,x,y)||visited[x][y]||grid[x-1][y]!=1)return;
        visited[x][y] = true;
        grid[x][y]=2;
        queue.offer(new int[]{x,y});
        //if(isvalid(grid,x-1,y)&&!visited[x-1][y]&&grid[x-1][y]==1){
            dfs(grid,x-1,y,visited, queue);//}
        //if(isvalid(grid,x+1,y)&&!visited[x+1][y]&&grid[x+1][y]==1){
            dfs(grid,x+1,y,visited, queue);//}
        //if(isvalid(grid,x,y-1)&&!visited[x][y-1]&&grid[x][y-1]==1){
            dfs(grid,x,y-1,visited, queue);//}
        //if(isvalid(grid,x,y+1)&&!visited[x][y+1]&&grid[x][y+1]==1){
            dfs(grid,x,y+1,visited, queue);//}
    }

    /**
     *找最短路径,用bfs!
     */
    private int bfs(Queue<int[]> queue,int[][] grid){

        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] now = queue.poll();
                for(int[] dict : dictions){
                    int newx = dict[0]+now[0];
                    int newy = dict[1]+now[1];
                    if(!isvalid(grid,newx,newy)||grid[newx][newy]==2){
                        continue;
                    }else if(grid[newx][newy]==1){
                        return count;
                    }else {
                        grid[newx][newy]=2;
                        queue.add(new int[]{newx,newy});
                    }
                }
            }
            count++;
        }
        return Integer.MAX_VALUE;
    }

    private boolean isvalid(int[][] grid,int x,int y) {
        if(x<0||y<0||x>=grid.length||y>=grid[0].length){return false;}
        else return true;
    }
}
/*
private void gotoSea(int[][] grid, int x, int y ){


        boolean[][] visited = new boolean[grid.length][grid[0].length];//visited[x-1][y] = true;
        dfs2(grid,x-1,y,visited,0);
        dfs2(grid,x+1,y,visited,0);
        dfs2(grid,x,y-1,visited,0);
        dfs2(grid,x,y+1,visited,0);
    }
    private void dfs2(int[][] grid, int x, int y, boolean[][] visited, int count){
        System.out.println("now x="+x+",y="+y);
        if(!isvalid(grid,x,y)||visited[x][y]||grid[x][y]==2){
            //不好意思啊,又回到2了,没鬼用
            return;
        }else if(grid[x][y]==1){
            //找到第二片大陆了
            min = Math.min(min,count);
            return;
        }
        visited[x][y]=true;
        //还在海里
        dfs2(grid,x-1,y,visited,count+1);
        dfs2(grid,x+1,y,visited,count+1);
        dfs2(grid,x,y-1,visited,count+1);
        dfs2(grid,x,y+1,visited,count+1);
        //visited[x][y]=false;
    }
 */

/*
public static void main(String[] args) {
        l934 solution = new l934();
        int[][] grid = new int[][]{
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,0,1,1,0,0},
                {0,0,0,1,1,0,1,0},
                {0,0,0,0,0,1,1,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };

        int res = solution.shortestBridge(grid);
        System.out.println(res);
    }
 */