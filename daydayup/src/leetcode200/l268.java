package leetcode200;

import java.util.Arrays;
import java.util.HashSet;

public class l268 {
    //按位异或运算（XOR）  那个重复异或就归0的并且有交换律的
    //这才是优雅的解法
    public int missingNumber4(int[] nums) {
        int xor = 0;
        for(int i = 0 ;i<=nums.length;i++){
            xor = xor^i;
        }
        for (int num : nums) {
            xor = xor^num;
        }
        return xor;
    }
    //5ms  哈希表
    public int missingNumber3(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 0; i < 1+nums.length; i++) {
            if(!hashSet.contains(i)){return i;}
        }
        return -1;
    }


    //6ms
    //自己得意洋洋的解法,实际像个傻子不如用法二
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        //int[] contrast = new int[nums.length];
        //还要二分查找,但是没用更快
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]!=mid&&(mid==0||nums[mid-1]==mid-1)){
                return mid;
            }
            else if(nums[mid]==mid){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return nums.length;
    }
    //6ms
    //排序后不用二分查找,遍历,速度一样的
    //这个只用一次遍历罢了,
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}
