package leetcode200;

import java.util.ArrayList;
import java.util.List;

public class l216v1 {
    //二刷
    public List<List<Integer>> combinationSum3(int k, int n) {
//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
//只使用数字1到9
//每个数字 最多使用一次
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k,n,res,new ArrayList<>(),1);
        return res;
    }
    public void backtrack(int k, int n,List<List<Integer>> res,List<Integer> path,int startItem){
        if(path.size()==k){
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum+=path.get(i);
        }
        if(sum==n){
            res.add(new ArrayList<>(path));
        }
        return;
        }

        for(int i = startItem;i<=9;i++){
            path.add(i);
            backtrack(k,n,res,path,i+1);
            path.remove(path.size()-1);
        }
    }
}
