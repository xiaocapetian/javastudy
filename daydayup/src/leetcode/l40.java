package leetcode;

import java.util.*;

public class l40 {//自己写的去重,超时了,其实去重很简单,看下一页
    public static void main(String[] args) {
        int[] candidates= {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates,8));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int i = 0; i < candidates.length-1; i++) {
            for (int j = 0;j<candidates.length-1-i;j++){
                if(candidates[j]>candidates[j+1]){
                    int temp = candidates[j];
                    candidates[j] = candidates[j+1];
                    candidates[j+1] = temp;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int startItem = 0;int sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        backtrack(candidates,target,startItem,deque,res,sum);
        return res;
    }
    static void backtrack(int[] candidates, int target, int startItem,
                          Deque<Integer> deque,List<List<Integer>> res,
                          int sum ){ //sum加进去
        System.out.println("deque="+deque);
        //System.out.println("dequearr="+dequearr);
        if(sum>target){return;}
        else if(sum==target){
            ArrayList<Integer> arr = new ArrayList<>(deque);
            //我写的去重
            if(!res.contains(arr)){
            res.add(new ArrayList<>(arr));}
            return;
        }
        for(int i = startItem;i<candidates.length;i++){
            deque.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,target,i+1,deque,res,sum);
            sum-=deque.removeLast();
        }
    }
}
