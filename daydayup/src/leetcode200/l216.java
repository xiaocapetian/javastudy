package leetcode200;

import java.util.ArrayList;
import java.util.List;

public class l216 {
    public static void main(String[] args) {
        System.out.println("res="+combinationSum3(3, 7));
    }
    static int[] arr = {1,2,3,4,5,6,7,8,9};
    public static List<List<Integer>> combinationSum3(int k, int n) {
//找出所有相加之和为 n 的 k 个数的组合
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        backtrack(k,n,res,new ArrayList<Integer>(),0,sum);
        return res;
    }
    static void backtrack(int k, int n, List<List<Integer>> res, List<Integer> list, int startItem,int sum){
        System.out.println(list);
        //System.out.println(res);

        if(list.size()>k){return;}

        if(list.size()==k&&sum==n){
            res.add(new ArrayList<>(list));
            return;}
        for(int i = startItem;i<arr.length;i++){
            list.add(arr[i]);
            sum+=arr[i];
            backtrack(k,n,res,list,i+1,sum);
            sum-=list.remove(list.size()-1);

        }

    }
}
