package leetcode200;

public class l289 {
    //自己写的
    public void gameOfLife(int[][] board) {

        int[][] shu = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                shu[i][j] = getNum(board,i,j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(shu[i][j]<2||shu[i][j]>3){
                board[i][j]=0;
                }else if(shu[i][j]==3){board[i][j]=1;}
            }}

    }
    private int getNum(int[][] board,int x,int y){
        int res = 0;
        if(x>0&&y>0){if(board[x-1][y-1]==1){res++;}}
        if(x>0){if(board[x-1][y]==1){res++;}}

        if(x>0&&y<board[0].length-1){if(board[x-1][y+1]==1){res++;}}
        if(y<board[0].length-1){if(board[x][y+1]==1){res++;}}
        if(x<board.length-1&&y<board[0].length-1){if(board[x+1][y+1]==1){res++;}}

        if(x<board.length-1){if(board[x+1][y]==1){res++;}}
        if(x<board.length-1&&y>0){if(board[x+1][y-1]==1){res++;}}
        if(y>0){if(board[x][y-1]==1){res++;}}

        return res;
    }
}
