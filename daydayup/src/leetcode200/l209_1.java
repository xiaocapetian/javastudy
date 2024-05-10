package leetcode200;

public class l209_1 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
        //长度最小的 连续子数组,老子看错题了,这nm
    }
    //滑动窗口!
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;int quick=0;int slow=0;int min=Integer.MAX_VALUE;
        for (; quick < nums.length; quick++) {//什么时候动quick
            sum+=nums[quick];
            while (sum>=target){//sum值大了才动slow
                min = Math.min(min,quick-slow+1);
                /*注意.和v0的区别在哪,改min的时候sum肯定是>=target的,因为还没有移动slow,sum还没减*/
                sum -= nums[slow];//动slow时要把sum也改;
                slow++;//什么时候动slow,
            }
            //System.out.println("q= "+quick+" s= "+slow+" sum= "+sum);
        }
        return min!=Integer.MAX_VALUE?min:0;
    }

}
