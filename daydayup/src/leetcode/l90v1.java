package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l90v1 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,res,new ArrayList<>(),0,used);
        return res;
    }
    public static void backtrack(int[] nums,List<List<Integer>> res,List<Integer> path,int startItem,boolean[] used){
        System.out.println("path= "+path);
        res.add(new ArrayList<>(path));
        //System.out.println("现在res是"+res);
        if(startItem==nums.length){return;}
        for(int i = startItem;i<nums.length;i++){
            //注意,判断重不重的逻辑在path.add之前!
            if(i>0&& nums[i]==nums[i-1]&&used[i-1]==false){//区别在这定一个usd[]
                /*为什么是used[i-1]==false呢?很简单,
                * 当,它和它的前一个相等,且前一个没有被使用,那就是重复了
                * */
                //这是一种去重,写起来简单,在组合问题在可以使用,排列就不行了,还可定一个usd[]来去重
                //System.out.println("有重复,跳");
                //System.out.println("used= "+ Arrays.toString(used));
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            //System.out.println("used= "+ Arrays.toString(used));
            backtrack(nums,res,path,i+1,used);
            path.remove(path.size()-1);
            used[i] = false;
            //System.out.println("used= "+ Arrays.toString(used));

        }

    }
}
