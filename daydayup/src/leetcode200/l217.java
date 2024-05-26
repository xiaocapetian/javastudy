package leetcode200;

import java.util.Arrays;
import java.util.HashSet;

public class l217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set =new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return true;
            }
        }

        return false;
    }


    //我不太懂为什么官解要出这个方法二
    public boolean containsDuplicatev1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/contains-duplicate/solutions/518991/cun-zai-zhong-fu-yuan-su-by-leetcode-sol-iedd/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
