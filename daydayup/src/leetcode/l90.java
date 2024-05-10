package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class l90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,res,new ArrayList<>(),0);
        return res;
    }
    public static void backtrack(int[] nums,List<List<Integer>> res,List<Integer> path,int startItem){
        System.out.println("path= "+path);
        res.add(new ArrayList<>(path));
        //System.out.println("现在res是"+res);
        if(startItem==nums.length){return;}
        for(int i = startItem;i<nums.length;i++){
            //注意,判断重不重的逻辑在path.add之前!
            if(i!=startItem&& nums[i]==nums[i-1]){
                /*还是记住这个for是树的一层,那i==startItem时是一层的第一个,这时候判断它前一位是他上一层,---那不是重复,对吧?*/
                //这是一种去重,写起来简单,在组合问题在可以使用,排列就不行了,还可定一个usd[]来去重
                //System.out.println("有重复,跳");
                continue;
            }

            path.add(nums[i]);

            //while (i-1!=startItem&&i<nums.length&&nums[i]==nums[i-1]){
                //System.out.println("i要递增，现在i= "+i+"增加为"+(i+1));
                //i++;
            //}

            //System.out.println("现在i= "+(i+1));
            backtrack(nums,res,path,i+1);
            //System.out.println("要回溯,回溯前path= "+path);
            //System.out.println("现在i= "+i);
            path.remove(path.size()-1);
            //System.out.println("回溯后"+path);

        }

    }
}