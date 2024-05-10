package leetcode700;
//遍历查找
//没用二分法是没有前途的！
public class l704 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }
        }
        return -1;

    }
}
