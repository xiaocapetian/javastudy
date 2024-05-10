package leetcode;

public class l45v1 {
    public int jump(int[] nums) {

        int maxcover = 0;//最大覆盖范围
        int laststep = 0;
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {//注意这里是i < nums.length-1;!!!要-1最后一步不要
            maxcover = Math.max(maxcover,i+nums[i]);
            if(i==laststep){
                laststep = maxcover;
                count++;
            }
        }
        return count;
    }
}
