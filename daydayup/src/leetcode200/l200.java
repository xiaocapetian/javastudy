package leetcode200;
/*在 LeetCode 中，「岛屿问题」是一个系列系列问题，比如：
L200. 岛屿数量 （Easy）
463. 岛屿的周长 （Easy）
695. 岛屿的最大面积 （Medium）
827. 最大人工岛 （Hard）
*/
public class l200 {
    //根据讲解自己写出来的,dfs怎么用
    //只要找到是1就变成2,递归

    public int numIslands(char[][] grid) {

        int wide = grid[0].length;
        int height = grid.length;
        int res=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(grid[i][j]=='1'){//如果还没访问过
            grid[i][j]='2';//标记为访问过
            if(i-1>=0){
            dfs(grid,i-1,j);}
            if(j-1>=0){
            dfs(grid,i,j-1);}
            if(i+1<grid.length){
            dfs(grid,i+1,j);}
            if(j+1<grid[0].length){
            dfs(grid,i,j+1);}
        }
    }
//另一种写法
    void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        /*在最开始判断这个点是否在范围内*/
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」

        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
//
//    作者：nettee
//    链接：https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
