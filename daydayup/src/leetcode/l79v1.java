package leetcode;

import java.util.HashSet;
import java.util.Objects;

//HashSet<List<Integer>>存已经访问过的坐标,而是自己定一个内部类Coordinate表示坐标
//应该是对的,但是仍然超时了
public class l79v1 {
    class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 重写equals和hashCode方法以确保HashSet的正确工作
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    boolean res;

    public boolean exist(char[][] board, String word) {

        for(int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                backtrack(board,word,new HashSet<>(),j,i,new StringBuilder());
                if(res){return true;}
            }
        }

        return res;
    }
    public void backtrack(char[][] board, String word, HashSet<Coordinate> hash, int x, int y, StringBuilder sb){
        Coordinate zhong = new Coordinate(x,y);
        hash.add(zhong);
        System.out.println(hash);
        System.out.println(sb);
        sb.append(board[y][x]);
        if(sb.toString().equals(word)){res=true;return;}
        Coordinate shang = new Coordinate(x,y-1);
        Coordinate zuo = new Coordinate(x-1,y);
        Coordinate xia = new Coordinate(x,y+1);
        Coordinate you = new Coordinate(x+1,y);
        if(x-1>=0&&!hash.contains(zuo)){
            backtrack(board, word, hash,x-1,y,sb);
            sb.deleteCharAt(sb.length()-1);
            hash.remove(zuo);
        }
        if(y-1>=0&&!hash.contains(shang)){
            backtrack(board, word, hash,x,y-1,sb);
            sb.deleteCharAt(sb.length()-1);
            hash.remove(shang);
        }
        if(x+1<board[0].length&&!hash.contains(you)){
            backtrack(board, word, hash,x+1,y,sb);
            sb.deleteCharAt(sb.length()-1);
            hash.remove(you);
        }
        if(y+1<board.length&&!hash.contains(xia)){
            backtrack(board, word, hash,x,y+1,sb);
            sb.deleteCharAt(sb.length()-1);
            hash.remove(xia);
        }

    }
}
