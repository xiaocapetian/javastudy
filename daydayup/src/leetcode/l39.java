package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates,7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    static void backtracking(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int startItem){
        //System.out.println("res="+res);
        System.out.println("list = "+list);
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        if(sum>target){
            return;
        }else if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startItem;
             i<candidates.length;
             i++){
            list.add(candidates[i]);
            backtracking(res,list,candidates,target,i);//!!!!!这里是i,不是startItem,否则会出倒序的错
            list.remove(list.size()-1);
        }

    }
}
