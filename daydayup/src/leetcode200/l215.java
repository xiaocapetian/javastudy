package leetcode200;

import java.util.Arrays;

public class l215 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        findKthLargest(nums,2);
    }
    //测试用例通过了，但耗时太长。
    static int res;
    public static int findKthLargest(int[] nums, int k) {

        quick(nums,k,0,nums.length-1);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i]+",");
//        }
        return res;
        /*👇我是傻子吗???这也能写错???*/
        //return k;
    }
    //优化后的快排
    public static void quick(int[] nums,int k,int shou,int wei){
        if(shou>wei){return;}
        //
        int left = shou;
        int right = wei;
        while (right>left){
            while (right>left&&nums[right]>=nums[shou]){
                right--;
            }
            while (right>left&&nums[left]<=nums[shou]){
                left++;
            }
            int temp = nums[right];
            nums[right] =nums[left];
            nums[left] =temp;

        }
        int temp = nums[right];
        nums[right] =nums[shou];
        nums[shou] =temp;
        System.out.println("现在"+ Arrays.toString(nums));
        //nums[right]现在是找到位置的索引数
        //现在索引为nums.length-k的就是我要找的,第k大的元素
//        if(k == right){res = nums[right];}
//        else if (k < right)  {quick(nums,k ,shou, right);}
//        else  {quick(nums,k, right + 1, wei-1);}
        //System.out.println("nums.length-k我要求的这个值在第:"+(nums.length-k)+"位");
        if(right==nums.length-k){res = nums[right];}
        else if(right>nums.length-k){
            System.out.println("排序前面,shou="+shou+"right-1="+(right-1));
            quick(nums,k,shou,right-1);
        }
        else {
            System.out.println("排序后面,right+1="+(right+1)+"wei="+wei);
            quick(nums,k,right+1,wei);
        }
//        quick(nums,k,shou,right-1);
//        quick(nums,k,right+1,wei);
    }

}
