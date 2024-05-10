package leetcode;

public class l45 {
    //C老师教的,很难想啊
    public int jump(int[] nums) {
        int n = nums.length;
        int count = 0;
        int maxReach = 0; // 当前覆盖范围的最大可达位置
        int lastJump = 0; // 上一步的最远跳跃位置

        /*注意,这里的i不是跳,是一个点一个点分析*/
        for (int i = 0;i<nums.length-1;i++){
            maxReach = Math.max(i+nums[i],maxReach);//在第i位的覆盖范围i+nums[i]如果比过去大,则换掉
            if(i==lastJump){//这个意思是,i已经游览到了上一次的最大的步数了,[再此期间,i已经考察了这一路可能到的最大点]
/*这一步就是把最远的点告诉lastJump*/
                lastJump = maxReach; //最远跳跃位置 设成 现在的最大的可覆盖位置
                count++;
            }

        }
        return count;
    }
}
