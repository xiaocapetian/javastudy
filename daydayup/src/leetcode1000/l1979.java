package leetcode1000;

public class l1979 {
    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<min){min = nums[i];}
            if(nums[i]>max){max = nums[i];}
        }
        for(int i = min;i>0;i--){
            if(min%i==0&&max%i==0){return i;}
        }
        return -1;
    }
}
