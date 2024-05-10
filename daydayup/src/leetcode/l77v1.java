package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l77v1 {
    //二刷再写一遍,问题多多
    public List<List<Integer>> combine(int n, int k) {
        //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n,k,res,new ArrayList<>(),0);

        return res;
    }
    public void backtrack(int n, int k,List<List<Integer>> res,List<Integer> path,int startItem){

        System.out.println("path = "+path);
        if(path.size()==k){
            res.add(new ArrayList<>(path));//又忘了要new一个
        }
        for(int i = startItem;i<n;i++){
            path.add(i);
            backtrack(n,k,res,path,i+1);
            path.remove(path.size()-1);
        }
    }
}
