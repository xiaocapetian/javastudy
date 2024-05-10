package leetcode;

public class l31 {
    public static void main(String[] args) {
        int[] nums = {2,3,1};
        //int[] nums = {1,3,2};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
    public static void nextPermutation(int[] nums) {
//41253下一个41325下一个是41352
        //41532下一个是42135
        //那么发现，是从后往前看，如果一直上升，一直往前看，直到下降的——这一位要变，和谁变？和后面最小的一个变，变完之后后面重排。
        //根据看答案获得的思路，自己写的，耗时极其的多，修改极其的多，结果还非常慢，我真的栓q
        if (nums.length<2)return;
        int min = nums.length-2;

        for (; min > 0; min--) {
            if(nums[min]<nums[min+1]){break;}
        }
        if(min==0&&nums[0]>nums[1]){//一直升
            int left = 0;
            int right = nums.length-1;
            reverse(left, right, nums);
            return;
        }

        int ci = min+1;
        while(ci<nums.length&&nums[ci]>nums[min]){
            ci++;
        }
        ci--;

        swap(nums, min, ci);

        int left = min+1;
        int right = nums.length-1;
        reverse(left, right, nums);
        //System.out.println("ci= "+ci+" min= "+min);
    }

    private static void reverse(int left, int right, int[] nums) {
        while(left < right){
            int cup2 = nums[left];
            nums[left] = nums[right];
            nums[right] = cup2;
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int min, int ci) {
        int cup = nums[min];
        nums[min] = nums[ci];
        nums[ci] = cup;
    }
}
