package leetcode900;

public class l977 {
    public int[] sortedSquares(int[] nums) {
        //给你一个按 非递减顺序 排序的整数数组   -----看到这个想到什么?两侧的正负数大,中间的小
        //输入：nums = [-4,-1,0,3,10]
        //左右两个指针,
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int step = 0;
        while (left<=right){
            int leftf = nums[left]*nums[left];
            int rightf = nums[right]*nums[right];
            if(leftf<rightf){
                res[res.length-1-step] = rightf;//从后往前写这个数组
                right--;
            }else {
                res[res.length-1-step] = leftf;
                left++;
            }
            step++;
        }
        return res;
    }
}
