package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }/*去重*/
            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i];
            while (left<right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                    /*为什么去重不能放在这里?最直白的思考过程，就是right还是一个数一个数的减下去的，所以在哪里减的都是一样的。
所以这种去重 是可以不加的。 仅仅是 把去重的逻辑提前了而已。*/
                    //while (left<right&&nums[right]==nums[right+1]){right--;}
                } else if(nums[left] + nums[right] < target){
                    left++;
                    //while (left<right&&nums[left]==nums[left-1]){left++;}
                }else if(nums[left] + nums[right] == target){
                    /*去重为什么不能放在这里?你想啊{0,0,0,0,0}和=0,一直去重还没收获结果呢!*/
                    //while (left<right&&nums[right]==nums[right+1]){right--;}
                    //while (left<right&&nums[left]==nums[left-1]){left++;}

//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[left]);
//                    list.add(nums[right]);
//                    res.add(list);

                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //这个非常难思考,b和c的去重应该放在这里,找到了一个符合条件的之后,起码收获了之后在去重
                    //而且这里是nums[right]==nums[right-1] ( 注意是right-1 )
                    while (left<right&&nums[right]==nums[right-1]){right--;}
                    while (left<right&&nums[left]==nums[left+1]){left++;}
                    //这一步别忘了!!!
                    right--;
                    left++;
                }

            }
        }
        return res;
    }
}
