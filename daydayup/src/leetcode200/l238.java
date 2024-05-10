package leetcode200;

public class l238 {
    //左右乘积列表定义为不包括自己这一位更快
    public int[] productExceptSelf3(int[] nums) {
        int len = nums.length;
        int[] res1 = new int[len];
        int[] res2 = new int[len];
        res1[0] = 1;
        for(int i = 1;i< len;i++){
            res1[i] = res1[i-1]*nums[i-1];
        }
        res2[len-1] = 1;
        for(int i = len-2;i>=0 ;i--){
            res2[i] = res2[i+1]*nums[i+1];
        }
        int[] result = new int[len];
        for(int i = 0;i<len;i++){
            //System.out.println(res[i][0]+","+res[i][1]);
            result[i] = res1[i]*res2[i];
        }

        return result;
    }
    //实验证明两个一维数组比一个二维数组快
    public int[] productExceptSelf(int[] nums) {

        int[][] res = new int[nums.length][2];
        res[0][0] = nums[0];
        for(int i = 1;i< nums.length;i++){
            res[i][0] = res[i-1][0]*nums[i];
        }
        res[nums.length-1][1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0 ;i--){
            res[i][1] = res[i+1][1]*nums[i];
        }
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            //System.out.println(res[i][0]+","+res[i][1]);

            if(i==0){
                result[i] =res[i+1][1]; }
            else if(i==nums.length-1){
                result[i] = res[i-1][0];
            }
            else {result[i] = res[i-1][0]*res[i+1][1];}

        }

        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] res1 = new int[nums.length];
        int[] res2 = new int[nums.length];
        res1[0] = nums[0];
        for(int i = 1;i< nums.length;i++){
            res1[i] = res1[i-1]*nums[i];
        }
        res2[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0 ;i--){
            res2[i] = res2[i+1]*nums[i];
        }
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            //System.out.println(res[i][0]+","+res[i][1]);

            if(i==0){
                result[i] =res2[i+1]; }
            else if(i==nums.length-1){
                result[i] = res1[i-1];
            }
            else {result[i] = res1[i-1]*res2[i+1];}

        }

        return result;
    }
}
