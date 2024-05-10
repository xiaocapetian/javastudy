package leetcode100;

import java.util.HashSet;
import java.util.Set;
//数字连续的最长序列（不要求序列元素在原数组中连续）的长度

public class l128 {
    /*本题的关键是什么呀，如果一个数比它小1的在集合里，就跳过了
    否则对它开展调查，不停+1，看比它大的在不在Set里
    * */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for(int num : nums){

            if(set.contains(num-1)){continue;}
            else{
                int i = num;
                int inum = 1;
                while(set.contains(i+1)){
                    i++;
                    inum++;
                }
                if(inum>max){max=inum;}
            }
        }
        return max;

    }
}
