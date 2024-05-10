package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l51 {
    //n皇后,我自己写出来的!我要起飞!
    //n皇后,n*n 放n个,那每一行肯定有一个,对吧.怎么回溯呢,第一层就是第一排,第一层中的for就遍历第一排的位置
    List<List<String>> res = new ArrayList<>();

    // List<String> 长这样[".Q..","...Q","Q...","..Q."]
    public List<List<String>> solveNQueens(int n) {

        backtrack(n,new ArrayList<>());
        return res;
    }
    public void backtrack(int n,List<Integer> path){
        if(path.size()==n){
            res.add(transfer(path));
            return;
        }
        for (int i = 0;i<n;i++){

            if(path.contains(i)){continue;}
            else if(!judgeXie(path,i))
            {continue;}

            else {
                path.add(i);
                backtrack(n,path);
                path.remove(path.size()-1);
            }

        }
    }
    public List<String> transfer(List<Integer> resInt){
        List<String> output = new ArrayList<>();
        for (Integer integer : resInt) {
            StringBuilder sb =new StringBuilder();
            for (int i = 0; i < resInt.size(); i++) {
                if(i!=integer)sb.append(".");
                else sb.append("Q");
            }
            output.add(sb.toString());
        }
        return output;
    }
    public boolean judgeXie(List<Integer> path,Integer wantToPut){
        //path.size()代表我要填的是第几行
        for (int i1 = 0; i1 < path.size(); i1++) {
            if(Math.abs(path.get(i1)-wantToPut)==path.size()-i1){
                return false;
            }
                //path.get(i1) 第i1行的Q在第几位
        }
        return true;
    }
}
