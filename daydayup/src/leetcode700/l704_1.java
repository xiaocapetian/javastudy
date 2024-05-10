package leetcode700;

public class l704_1 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target =13;
        System.out.println(search(nums,target));
        System.out.println("返回范围");
        System.out.println(searchInsert(nums,target));
    }
    //left<=right这里是>还是>=要看区间合法吗??左闭右闭的话就合法[1,1],那while(left<=right) .左闭右开的话[1,1)不合法,那while(left<right)
    //左闭右闭版
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            //System.out.println("(left + right) / 2= "+(left + right) / 2+"num= "+ nums[(left + right) / 2]);
            if (nums[mid]== target) {
                return mid ;
            } else if (nums[mid] <target) {
                left = mid+1 ;
            } else {
                right = mid-1 ;
            }
        }
        return -1;
    }
    //左闭右开版
    class Solution {
        public static int search2(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while(left<right) {
                //System.out.println("(left + right) / 2= "+(left + right) / 2+"num= "+ nums[(left + right) / 2]);
                int mid = left + (right-left)/2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] <= target) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            return -1;



        }

    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid; // 目标元素存在于数组中，返回其索引
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 当退出循环时，left 表示第一个大于 target 的元素位置，也是插入位置
        return left;   //查找2,返回2
        /*        int[] nums = {-1, 0,   3, 5,9,12};
                                    👆   👆
                                 right,  left
                                 为什么返回left看出来了吧!!!
        int target =13;返回6*/
        //return right; //返回1
    }
}
