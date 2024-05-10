package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//看了一眼题解然后自己写的,别沉迷拼字符串了,一位一位对比,符合就继续下一位,startItem++;不符合就直接回溯
//击败5%我尽力了,,,1829ms
public class l79v2 {
    boolean res;

    public boolean exist(char[][] board, String word) {

        //String[] wordarr = word.split("");
        char[] wordarr = word.toCharArray();
        for(int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                backtrack(board,wordarr,new HashSet<>(),j,i,0);
                if(res){return true;}
            }
        }

        return res;
    }
    public void backtrack(char[][] board, char[] wordarr, HashSet<List<Integer>> hash, int x, int y,int startItem){
        List<Integer> zhong = new ArrayList<>();
        zhong.add(x);zhong.add(y);
        hash.add(zhong);
        //System.out.println(hash);
        //System.out.println(sb);

        if(board[y][x]==(wordarr[startItem])&&startItem== wordarr.length-1){res=true;return;}
        if(board[y][x]==(wordarr[startItem])){
            List<Integer> shang = new ArrayList<>();
            shang.add(x);shang.add(y-1);
            List<Integer> zuo = new ArrayList<>();
            zuo.add(x-1);zuo.add(y);
            List<Integer> xia = new ArrayList<>();
            xia.add(x);xia.add(y+1);
            List<Integer> you = new ArrayList<>();
            you.add(x+1);you.add(y);
            if(x-1>=0&&!hash.contains(zuo)){
                backtrack(board, wordarr, hash,x-1,y,startItem+1);
                hash.remove(zuo);
            }
            if(y-1>=0&&!hash.contains(shang)){
                backtrack(board, wordarr, hash,x,y-1,startItem+1);
                hash.remove(shang);
            }
            if(x+1<board[0].length&&!hash.contains(you)){
                backtrack(board, wordarr, hash,x+1,y,startItem+1);

                hash.remove(you);
            }
            if(y+1<board.length&&!hash.contains(xia)){
                backtrack(board, wordarr, hash,x,y+1,startItem+1);
                hash.remove(xia);
            }
        }
        hash.remove(zhong);
    }
}
