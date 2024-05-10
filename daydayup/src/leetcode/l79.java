package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//HashSet<List<Integer>>存已经访问过的坐标,如果用HashSet<int[]>,因为数组[1,2][1,2]是地址,所以还是回相等,所以用List<Integer>表示坐标
//应该是对的,但是超时了
//v0v1都超时 v2击败5%,
// v4看了很多眼题解然后写的,击败击败23.22%----还不错,,,233ms,比力扣答案还快
// v5二刷自己写的方法击败77%很流畅!
public class l79 {
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
    public void backtrack(char[][] board, String word, HashSet<List<Integer>> hash,int x,int y,StringBuilder sb){
        List<Integer> zhong = new ArrayList<>();
        zhong.add(x);zhong.add(y);
        hash.add(zhong);
        System.out.println(hash);
        System.out.println(sb);
        sb.append(board[y][x]);
        if(sb.toString().equals(word)){res=true;return;}
        List<Integer> shang = new ArrayList<>();
        shang.add(x);shang.add(y-1);
        List<Integer> zuo = new ArrayList<>();
        zuo.add(x-1);zuo.add(y);
        List<Integer> xia = new ArrayList<>();
        xia.add(x);xia.add(y+1);
        List<Integer> you = new ArrayList<>();
        you.add(x+1);you.add(y);
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
