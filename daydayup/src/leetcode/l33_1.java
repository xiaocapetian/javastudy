package leetcode;

public class l33_1 {
    //看官方解答写
    //头脑放聪明啊！！！！
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        //int[] nums = {5,1,3};
        System.out.println(search(nums,0));
    }
    public static int search(int[] nums, int target) {
         if(nums.length==0)return -1;
         if(nums.length==1)return nums[0]==target?0:-1;
         int left = 0, right = nums.length-1;
         while (left<right){
             int mid = left+(right-left)/2;
             if(nums[mid]==target)return mid;
             //把下文的0和nums.length-1换成left和right我更能理解，也是可行的，我只好奇，但是为什么不换也不报错
             if(nums[0]<nums[mid]){
                 if(nums[0]<=target&&nums[mid]>target){//找递增的部分
                     right =mid -1;
                 }
                 else {
                     left = mid+1;
                 }
             }else {
                 System.out.println("else");
                 if(nums[mid]<=target&&nums[nums.length-1]>=target){

                     left = mid +1;
                 }
                 else {
                     right =mid -1;
                 }
             }


         }
         return  -1;



    }

}
