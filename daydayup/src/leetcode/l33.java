package leetcode;
//自己写的
public class l33 {
    public static void main(String[] args) {
        //int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {5,1,3};
        System.out.println(search(nums,5));
    }
    public static int search(int[] nums, int target) {

        int left = 0,right = nums.length-1;
        return (erfenserch(nums, target,left,right));

    }

    private static int erfenserch(int[] nums, int target,int left,int right) {

        int mid = left+(right-left)/2;
        int result = -1;
        if(nums[left]<= nums[mid]){
            //System.out.println("nums["+left+"]<= nums["+mid+"]");
            if (target >= nums[left]&& target <= nums[mid]){
                //System.out.println("target >= nums["+left+"]&& target <= nums["+mid+"]");
                right = mid;
                result = erfen(nums,target,left,right);
                //System.out.println("result = "+result);
                return result;
            }
            else if(mid+1<=right){result = erfenserch(nums, target,mid+1,right);}
            else {return -1;}
        }else{
            //System.out.println("else");
            if(target >= nums[mid]&& target <= nums[right]){
                //System.out.println("target >= nums["+mid+"]&& target <= nums["+right+"]");
                left = mid;
                result = erfen(nums,target,left,right);
                return result;
            }
            else if (left<=mid-1){result = erfenserch(nums, target,left,mid-1);}
            else {return -1;}
        }
        //System.out.println("azhe");
        return result;
    }
    private static int erfen(int[] nums, int target,int left,int right){
        //System.out.println("haha");
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                System.out.println("ha");
                return mid;}
            if(nums[mid]<target){
                left = mid+1;
            }else {right = mid - 1;}
        }
        return -1;
    }

}
