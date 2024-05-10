package leetcode100;

public class l130 {
    //运行时间还可以接受
    public void solve(char[][] board) {
        int wide = board[0].length;
        int height = board.length;
        int res=0;
        for (int i = 0; i < height; i++) {
            if(board[i][0]=='O'){
                res++;
                dfs(board,i,0);
            }
            if(board[i][wide-1]=='O'){
                res++;
                dfs(board,i,wide-1);
            }
        }
        for (int j = 0; j < wide; j++) {
            if(board[0][j]=='O'){
                res++;
                dfs(board,0,j);
            }
            if(board[height-1][j]=='O'){
                res++;
                dfs(board,height-1,j);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                if(board[i][j]=='C'){board[i][j]='O';}
                else if(board[i][j]=='O'){board[i][j]='X';}
            }
        }
        return ;
    }

    private void dfs(char[][] board, int i, int j) {
        /*在最开始判断这个点是否在范围内*/
        if (!inArea(board, i, j)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j]= 'C';

// 访问上、下、左、右四个相邻结点
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board,  i, j - 1);
        dfs(board,i, j + 1);
    }
    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
}
