package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l15 {
    //是抄了答案的,关键是怎么想到的?!?
    //这题要去重,那么就不适合像两数之和那样用哈希法了,反而拿出了排序后指针法!
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {

            //first前进一次,如果到达点与上一步相同就再前进一次
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //first遍历数组,定好后 区间用second和 third占住左右
            int second = first+1;
            int third = nums.length - 1;
            int target = -nums[first];
            for (; second < nums.length; second++){
                if (second > first+1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second]+ nums[third] > target){
                    third--;
                }
                if(second == third){
                    break;//什么时候跳出循环
                }
                if(nums[second]+ nums[third] == target){
                    List<Integer> ll = new ArrayList<>();
                    ll.add(nums[first]);
                    ll.add(nums[second]);
                    ll.add(nums[third]);
                    result.add(ll);
                }
            }

        }
        return result;
    }
}
