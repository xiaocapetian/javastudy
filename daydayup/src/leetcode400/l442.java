package leetcode400;

import java.util.ArrayList;
import java.util.List;

/**
 * 腾讯2面真题
 * [难点]长度是1-n,每个数字又在1-n范围内【放聪明啊，为什么要给你这个条件啊，肯定有意图啊】,那居然能想到要排序
 * [易错]  交换完之后,换上来的新的数字,要接着交换,直到换不动(出现两个数一样换了也白换)为止
 */
public class l442 {
    //这题好像在哪见过
    //虽然和异或那题很像,但方法完全不一样
    //长度是1-n,每个数字又在1-n范围内,那居然能想到要排序
    /**
     * @param nums 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
     * @return 请你找出所有出现 两次 的整数，并以数组形式返回。
     */
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while(nums[i]!=nums[nums[i]-1]){/*[易错]:这一步不可缺少,交换完之后,换上来的新的数字,要接着交换,直到换不动(出现两个数一样换了也白换)为止*/
                swap(nums,i,nums[i]-1);
            }
        }
        //==
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                res.add(nums[i]);
            }
        }
        return res;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
