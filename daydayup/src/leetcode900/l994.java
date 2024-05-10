package leetcode900;

public class l994 {
    //为什么就能想到要广搜呢?
    public int orangesRotting(int[][] grid) {

        int wide = grid[0].length;
        int high = grid.length;


        for (int i = 0; i < high; i++) {
            for (int j = 0; j < wide; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j,3);
                }
            }
        }
        int day=3;
        for (int i = 0; i < high; i++) {
//     System.out.println(Arrays.toString(grid[i]));
            for (int j = 0; j < wide; j++) {
                if(grid[i][j] == 1){return -1;}
                day = Math.max(day,grid[i][j]);
            }}
        return day-3;
    }
    private void dfs(int[][] grid,int x,int y,int day){

        if(!vaild(grid,x,y)||grid[x][y]==0){return ;}
        if(grid[x][y]!=1&&grid[x][y]<day-1){return ;}
        if(grid[x][y] ==1 ){grid[x][y] =day;}else {
            grid[x][y] = Math.min(day,grid[x][y]);//如果=2也不会改掉的,放心
        }
        //System.out.println("hello");
        dfs(grid,x-1,y,day+1);
        dfs(grid,x,y-1,day+1);
        dfs(grid,x+1,y,day+1);
        dfs(grid,x,y+1,day+1);

    }
    private boolean vaild(int[][] grid,int x,int y){
        if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length){
            return true;
        }else return false;
    }
}
