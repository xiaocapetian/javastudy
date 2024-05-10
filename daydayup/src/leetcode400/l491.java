package leetcode400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class l491 {
    //是自己写的,且我又优化了v1
    private Set<List<Integer>> resSet = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        backtrack(new ArrayList<>(),0,nums);
        List<List<Integer>> res = new ArrayList<>(resSet);
        return res;
    }
    public void backtrack (List<Integer> path,int startItem,int[] nums){
        //System.out.println("path= "+path);
        if(path.size()>1&&issheng(path)){//没有剪枝还要靠函数判断,太慢了!我又优化了v1
            resSet.add(new ArrayList<>(path));
        }
        for(int i = startItem;i<nums.length;i++){

            path.add(nums[i]);
            backtrack(path,i+1,nums);
            path.remove(path.size()-1);
        }
    }
    //判断子序列是不是增的
    public boolean issheng(List<Integer> path){
        for (int i = 1; i < path.size(); i++) {
            if(path.get(i)<path.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
