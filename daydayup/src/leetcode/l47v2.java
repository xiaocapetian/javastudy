package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l47v2 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(),used);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used) {
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0;i<nums.length;i++){
            //while (i!=0&&i<nums.length&&nums[i]==nums[i-1]){i++;}
            //while(i!=0&&i<nums.length&&nums[i]==nums[i-1]&&!used[i-1]){i++;}
            //如果要用👆这个while,那下面就必须判断是不是 已经i=nums.length了 ,还是用 if continue简单

            //如何跳过,i!=0&&nums[i]==nums[i-1]就跳吗?不对,那会把一个树枝上的也给跳掉了,
            /*这地方和组合不一样,组合有startItem,这里每一层都是从头到尾的, */
            //所以应该怎么办?不久满足上面的,还需要!used[i-1]    <<<=====想一下,同一层的 是不是上一个 就是没有没有用过的 ,纵向的上一个就是用过的
            if (i!=0&&nums[i]==nums[i-1]&&!used[i-1]){continue;}/*[难点易错点]*/
            if(!used[i]){
                used[i]=true;
                path.add(nums[i]);
                backtrack(nums,path,used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
