package leetcode400;

public class l494 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(findTargetSumWays(nums,  target));
    }
    //为什么想到背包问题很关键
    //还是二维数组简单啊
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum < Math.abs(target)){
            return 0;
        }
        int leftTarget = (sum+target)/2;
        /* L+R = sum
        *  L-R = tar
        *  L = (sum+tar)/2 */

        if((sum+target)%2==1)return 0;
        int[][] bp = new int[nums.length][leftTarget+1];
        /*bp数组的定义为:bp[i][j]就是要求的那个,背包容量从0加到target,
        *          */
        //对于第一行初始化，其实不需要遍历
        if(nums[0]<=leftTarget){bp[0][nums[0]]=1;}
//        for (int j = 1; j<leftTarget+1;j++){
//            if(nums[0]==j){bp[0][j]=1;}
//        }
        //[这一步很关键!!!]对于第一列初始化,对第一列0的那列要重视！就遍历0的那列！别遍历1的那列了!
        int num0 = 0;
        for (int i = 0; i<nums.length;i++){
            if(nums[i]==0){
                //bp[i-1][1]*2;
                num0++;
            }
            bp[i][0]=(int) Math.pow(2,num0);
        }
        // for (int i = 1; i<nums.length;i++){
        //     if(nums[i]==1){
        //         bp[i][1]=bp[i-1][1]+1;
        //     }else if(nums[i]==0){
        //         bp[i][1]=bp[i-1][1]*2;
        //     }
        //     else{bp[i][1]=bp[i-1][1];}
        // }
        //if(leftTarget==1){return bp[nums.length-1][1];}
        for(int i = 1;i<nums.length;i++){
            for (int j = 1; j<leftTarget+1;j++){
                if(j>=nums[i]){
                    bp[i][j] = bp[i-1][j]+bp[i-1][j-nums[i]];}
                else {
                    bp[i][j] = bp[i-1][j];
                }
            }
        }
        //      for(int i = 0;i<nums.length;i++){
        //      for (int j = 0; j<leftTarget+1;j++){

        //          System.out.print(bp[i][j]+",");}
        //          System.out.println();
        //  }
        return bp[nums.length-1][leftTarget];
    }
}
