package leetcode;

/**
 * 二刷一下 一不小心写出一个击败77%,我好厉害啊
 * //重难点: visited[x-1][y] = false; 这里必须有回溯!
 */
public class l79v5 {

    boolean res;
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, word, visited, i, j, 0);
                if(res)return true;
            }
        }
        return false;
    }

    private void dfs(char[][] board,String word,boolean[][] visited,int x, int y, int num) {
        if(board[x][y]!=word.charAt(num))return ;

        visited[x][y]=true;
        num++;
        if(num==word.length()){
            res = true;
            return ;}
        if(isVaild(board,x-1,y)&& !visited[x-1][y]){dfs(board,word,visited,x-1,y,num);
            visited[x-1][y] = false; /*[难点]:这里必须有回溯!*/
        }
        if(isVaild(board,x+1,y)&& !visited[x+1][y]){dfs(board,word,visited,x+1,y,num);
            visited[x+1][y] = false;
        }
        if(isVaild(board,x,y-1)&& !visited[x][y-1]){dfs(board,word,visited,x,y-1,num);
            visited[x][y-1]= false;
        }
        if(isVaild(board,x,y+1)&& !visited[x][y+1]){dfs(board,word,visited,x,y+1,num);
            visited[x][y+1]= false;
        }

    }
    private boolean isVaild(char[][] board,int x, int y){
        if(x<0||y<0||x>=board.length||y>=board[0].length)return false;//不合法
        return true;
    }
}
