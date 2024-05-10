package leetcode;

import java.util.ArrayList;
import java.util.List;
//看了很多眼题解然后写的,还是击败击败23.22%还不错,,,233ms,比力扣答案还快
public class l79v4 {
    boolean res;
    //boolean[][] visited = new boolean[h][w];     boolean[][] visited判断重不重复,看了很多眼题解自己写的
    public boolean exist(char[][] board, String word) {

        //String[] wordarr = word.split("");
        char[] wordarr = word.toCharArray();
        int h = board.length, w = board[0].length;
        //boolean[][] visited = new boolean[h][w];
        for(int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                backtrack(board,wordarr,j,i,0,new boolean[h][w]);
                if(res){return true;}
            }
        }

        return res;
    }
    public void backtrack(char[][] board, char[] wordarr,  int x, int y, int startItem,boolean[][] visited){
        List<Integer> zhong = new ArrayList<>();
        zhong.add(x);zhong.add(y);
        visited[y][x]=true;
        //System.out.println(hash);
        //System.out.println(sb);

        if(board[y][x]==(wordarr[startItem])&&startItem== wordarr.length-1){res=true;return;}
        if(board[y][x]==(wordarr[startItem])){

            if(x-1>=0&& !visited[y][x - 1]){
                backtrack(board, wordarr,x-1,y,startItem+1,visited);
                visited[y][x-1]=false;

            }
            if(y-1>=0&& !visited[y - 1][x]){
                backtrack(board, wordarr,x,y-1,startItem+1,visited);
                visited[y-1][x]=false;
            }
            if(x+1<board[0].length&& !visited[y][x + 1]){
                backtrack(board, wordarr,x+1,y,startItem+1,visited);
                visited[y][x+1]=false;
            }
            if(y+1<board.length&& !visited[y + 1][x]){
                backtrack(board, wordarr, x,y+1,startItem+1,visited);
                visited[y+1][x]=false;
            }
        }
        visited[y][x]=true;
    }
}
