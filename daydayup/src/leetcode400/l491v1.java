package leetcode400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class l491v1 {
    private Set<List<Integer>> resSet = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        backtrack(new ArrayList<>(),0,nums);
        List<List<Integer>> res = new ArrayList<>(resSet);
        return res;
    }
    public void backtrack (List<Integer> path,int startItem,int[] nums){
        //System.out.println("path= "+path);
        if(path.size()>1){
            if(path.get(path.size()-1)>=path.get(path.size()-2)){
                resSet.add(new ArrayList<>(path));}
            else{//如果不大于立刻终止,  否则会出现 8,9,1被排除  8,9,0,1却被加进去
                return;
            }
        }
        for(int i = startItem;i<nums.length;i++){

            path.add(nums[i]);
            backtrack(path,i+1,nums);
            path.remove(path.size()-1);
        }
    }

}
