package leetcode400;

public class l463 {
    //一遍过,我厉害着呢
    public int islandPerimeter(int[][] grid) {

        int wide = grid[0].length;
        int height = grid.length;
        int count=0;
        for(int i = 0;i<height;i++){
            for(int j = 0;j<wide;j++){
                if(grid[i][j]==1){
                    count = dfs(grid,i,j,count);
                }

            }
        }
        return count;
    }
    private int dfs(int[][] grid,int i,int j,int count){
        if(!vaild(grid,i,j)){return 0;}
        grid[i][j] = 2;
        if(i==0||(grid[i-1][j]==0)){//上面是边或水
            count++;
        }else if(grid[i-1][j]==1){
            count = dfs(grid,i-1,j,count);
        }
        if(j==0||(grid[i][j-1]==0)){//左面是边或水
            count++;
        }else if(grid[i][j-1]==1){
            count = dfs(grid,i,j-1,count);
        }
        if(i==grid.length-1||(grid[i+1][j]==0)){//下面是边或水
            count++;
        }else if(grid[i+1][j]==1){
            count = dfs(grid,i+1,j,count);
        }
        if(j==grid[0].length-1||(grid[i][j+1]==0)){//右面是边或水
            count++;
        }else if(grid[i][j+1]==1){
            count = dfs(grid,i,j+1,count);
        }

        return count;
    }
    private boolean vaild(int[][] grid,int i,int j){
        if(i>=0&&j>=0&&i<grid.length&&j<grid[0].length){
            return true;
        }
        return false;
    }

}
