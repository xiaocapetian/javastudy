package leetcode400;

import java.util.ArrayList;
import java.util.List;

public class l491v2 {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        backtrack(new ArrayList<>(),0,nums);
        //List<List<Integer>> res = new ArrayList<>(resSet);
        return res;
    }
    public void backtrack (List<Integer> path,int startItem,int[] nums){
        //System.out.println("path= "+path);

        if(path.size()>1){
            if(path.get(path.size()-1)>=path.get(path.size()-2)){
                res.add(new ArrayList<>(path));
            }
            else{//如果不大于立刻终止,  否则会出现 8,9,1被排除  8,9,0,1却被加进去
                return;
            }
        }

        /*
         这里简单举个例子吧，没图的话本来也不大好理解，nums={4,7,6,7},当走到第二层调用到7时，此时如果used写在函数里面的话，
         是不是已经使用一次了对吧，像下再执行到7时，就不再使用了。此时回溯到6时，也是在第二层，当执行过后，然后像下再执行时
         7时，也不再使用了。说白了原因就是因为没更新used数组。
         为什么我举例跟样例不一样呢？是因为他的样例比较误导咱们做题，画图时会很不容易得到他的结果集，你们可以根据我举的例子
         和解释去画下图吧。
         */
        //这里十分注意，对于used数组  如果写在函数里面，代表会对同一树层上和同一树枝上的重复元素都不能重复使用。
        //而写成used数组，是只对同一树层上的重复元素不能重复使用
        /* used数组写在这,每一次递归函数都新建一个used,每一次递归函数代表一个父节点,这个for就是它的一层孩子,
        * 既然我判断的是同一树层上有没有重复,那自然写在这*/
        //造成这种结果的原因是因为写在函数里面的used数组不会因为像下递归的时候去更新used数组，一直使用的传入的used这个参数。
        //为什么我这里要特此声明呢？是因为跟全排列||，组合总和||和子集||的解法不同
        int[] used = new int[201];
        for(int i = startItem;i<nums.length;i++){
            if(used[nums[i]+100]==1){continue;}
            used[nums[i]+100]=1;// 记录这个元素在本层用过了，本层后面不能再用了
            path.add(nums[i]);

            backtrack(path,i+1,nums);

            Integer remove = path.remove(path.size() - 1);
            //used[remove+100]--;
            //这里used数组千万不能赋值为0，为什么?
            //因为一个for是一个父节点下的一层,我就要逮在一层中重复的子点,你打到孙子回溯完,到二弟时就要看大儿子和二儿子重复否,
            // 你怎么能把used回溯呢?
        }
    }
}
