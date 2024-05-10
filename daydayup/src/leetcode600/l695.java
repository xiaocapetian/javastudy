package leetcode600;

public class l695 {
    public int maxAreaOfIsland(int[][] grid) {
        int wide = grid[0].length;
        int height = grid.length;
        int maxArea=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                if(grid[i][j]==1){

                    int area = dfs(grid,i,j);
                    System.out.println("area="+area);
                    maxArea = Math.max(maxArea, area);
                }

            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int i, int j) {
        if(!vaild(grid,i,j)){return 0;}
        else if(grid[i][j]==0||grid[i][j]==2){return 0;}
        else {//if(grid[i][j]==1)
            int area = 1;/*在这里new一个area,而不是作为参数传过来(会重复计算*/
            grid[i][j]=2;

        int area1= dfs(grid, i - 1, j);
        int area2=dfs(grid, i + 1, j);
        int area3= dfs(grid, i, j - 1);
        int area4= dfs(grid, i, j + 1);

        return area+area1+area2+area3+area4;
        }
    }
    // 判断坐标 (r, c) 是否在网格中
    boolean vaild(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }


}
