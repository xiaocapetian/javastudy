package leetcode2000;

import java.util.ArrayList;
import java.util.List;

public class l2831v1 {
    /**思路太神奇了,第一次见啊
     * @param nums 给你一个下标从 0 开始的整数数组 nums
     * @param k
     * @return 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
    从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。子数组 是数组中一个连续且可能为空的元素序列。

    虽然是互动窗口+双指针,但是如果你直接对nums上双指针滑窗,会非常麻烦,
    于是   一个神奇的思路,我不在整个nums上双指针滑窗,我把这个切到n个切面上

     有一个很神奇的思路,造一个List<Integer>[] losList，遍历，nums  nums = [1,3,2,3,1,3], k = 3
    那losList[3] = {1,3,5}  losList[1] = {0,4}
     那么对每一个losList[i] = los , 双指针left right滑窗    最后确定的双指针left right
    他们之间的距离是losList[3](right)-left[3](left)+1
     他们中有right - left+1个相同的元素i
     所以要删(losList[3](right)-left[3](left)) - (right - left)个
    若>k,则不符合要求,那就得left++ 了 否则可以和res比max  然后right继续向前滑
     */

    public int longestEqualSubarray(List<Integer> nums, int k) {
        List<Integer>[] losList = new ArrayList[nums.size()+1];
        for (int i = 0; i < losList.length; i++) {
            losList[i] = new ArrayList<>();
        }
        for (int i = 0; i < nums.size(); i++) {
            losList[nums.get(i)].add(i);
        }
        int res = 0;
        for (List<Integer> los : losList) {
            if(los.size()<=res){continue;}//加一个剪枝
//            for(int left = 0; left < los.size()-1; left++) {
//                for (int right = left+1; right < los.size(); right++) {
            /*[易错1]👆这样子不行,因为如果nums =[1]   k =0 压根不进循环*/
            //那么👇这样子终于是对的了,但是还是太慢,超时
//            for(int left = 0; left < los.size(); left++) {
//                for (int right = left; right < los.size(); right++) {
//                    int deleteNum = los.get(right)-los.get(left)-right+left;
//                    if(deleteNum<=k){
//                        res = Math.max(res,right - left+1);
//                    }
//                }
//            }
            /*[易错+重难!!!]没让你left和right来个2重循环啊傻瓜?!?!?
            * 这照样是左右指针,right前进,一旦发现los.get(right)-los.get(left)-right+left>k 了 , left就要前进!!!*/
            int left = 0;
            for(int right = 0; right < los.size(); right++){
                //int left = 0;   //那你怎么能在定义left呢???肯定是双指针滑动窗口啊!!!

                while (los.get(right)-los.get(left)-right+left>k){
                    left++;
                }
                res = Math.max(res,right - left+1);
            }
        }

        return res;
    }
}
