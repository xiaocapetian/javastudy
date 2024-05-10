package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leecode_1_1 {
    public static void main(String[] args) {
        int[] nums = {1,9,7,4,2,3};
        twoSum(nums,6);
    }
    public static int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表，用于存储数组元素及其对应的索引
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        // 类名Map<key, value>   对象名   = new    类名(这里要写明是哈希map)   ;
        System.out.println(hashtable);
        // 遍历数组
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(hashtable);
            // 计算目标值与当前元素的差值
            int complement = target - nums[i];
            //int i1 = target - nums[i];

            // 判断差值是否已经在哈希表中
            if (hashtable.containsKey(complement)) {
                // 如果存在，返回结果，包括差值的索引和当前元素的索引
                return new int[]{hashtable.get(complement), i};
            }

            // 如果差值不在哈希表中，将当前元素及其索引加入哈希表
            hashtable.put(nums[i], i);
        }

        // 如果遍历完数组都没有找到符合条件的元素，返回空数组
        return new int[0];
    }
}
