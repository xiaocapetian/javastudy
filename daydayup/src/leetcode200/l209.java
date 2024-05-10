package leetcode200;

public class l209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
        //长度最小的 连续子数组,老子看错题了,这nm
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;int quick=0;int slow=0;int min=nums.length;
        for (; quick < nums.length; quick++) {
            sum+=nums[quick];
            while (sum-nums[slow]>=target){
                sum-=nums[slow];slow++;
            }
//太复杂,看v1,先改min,再移动slow没这么多破事
            if(sum>=target&&quick-slow+1<min){
                min=quick-slow+1;
            }
            //System.out.println("q= "+quick+" s= "+slow+" sum= "+sum);
        }
        return sum>=target?min:0;
    }
    //


    /*
    public static int minSubArrayLen(int target, int[] nums) {
//输入：target = 7, nums = [2,3,1,2,4,3]
        int sum = 0;int count =0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            sum += nums[nums.length-1-i];count++;
            System.out.println("nums[nums.length-1-i]= "+nums[nums.length-1-i]+" sum= "+sum+" count= "+count);
            if(sum>=target){
                return count;
            }

        }
        sum+=nums[0];count++;
        return sum>=target?count:0;
    }*/
}
