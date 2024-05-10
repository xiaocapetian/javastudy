package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [重难点]:排列 中 path.add(nums[i]);used[i]++;要放在for循环内,贴着backtrack
 */
public class l46 {
    private int[] used = new int[21];
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        backtrack(nums,new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums,  List<Integer> path){

        //排列就不用startItem了,只需要判断这个用没用过就行了
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i<nums.length;i++){//排列是从0开始
            if(used[nums[i]+10]==0){//这是因为输入-10 <= nums[i] <= 10
                path.add(nums[i]);
                used[nums[i]+10]++;
            }else{
                continue;
            }
            backtrack(nums,path);
            path.remove(path.size()-1);
            used[nums[i]+10]--;
        }
    }
}
