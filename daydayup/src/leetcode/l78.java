package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l78 {
    //全自己写!
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,res,new ArrayList<>(),0);
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path,int startItem){

        res.add(new ArrayList<>(path));
        //System.out.println("path = "+path);
        if(startItem==nums.length){

            return;
        }
        for (int i = startItem;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums,res,path,i+1);
            path.remove(path.size()-1);
        }
    }
}
