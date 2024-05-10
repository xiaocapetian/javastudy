package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l47 {

    /**
     * 我自己写的很巧妙啊
     */
    private List<List<Integer>> res = new ArrayList<>();
    //画图就理解了!  我自己写的!
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used = new int[nums.length];//两个used,第一个用来控制一次遍历中,不要出相同索引的,[可以数字相同,索引不同
        //Arrays.sort(nums); 我这个方法甚至不用排列
        backtrack(nums,new ArrayList<>(),used);
        return res;
    }
    public void backtrack(int[] nums,  List<Integer> path,int[] used){

        //排列就不用startItem了,只需要判断这个用没用过就行了
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        int[] cenUsed = new int[21];/*第二个used,控制的是一层不要出相同的*/
        for (int i = 0;i<nums.length;i++){//排列是从0开始
            if(used[i]==0&&cenUsed[nums[i]+10]==0){

                path.add(nums[i]);
                cenUsed[nums[i]+10]++;//你能回溯它吗?你不能
                used[i]++;
                backtrack(nums,path,used);
                path.remove(path.size()-1);
                used[i]--;

            }

        }
    }
}
