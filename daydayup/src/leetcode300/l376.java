package leetcode300;

public class l376 {
    //老师画出图后我自己写的,但是调整了很久   老师的解法是curDiff preDiff
    public int wiggleMaxLength(int[] nums) {

        if(nums.length==1)return 1;
        if(nums.length==2){
            if(nums[0]!=nums[1])return 2;
            else {return 1;}
        }
        int count = 1;

        for (int i = 1;i<nums.length;i++){
            int tong = 0;
            //如果和下一个相同就一路往前,tong记录同了一个
            while (i<nums.length-1&&nums[i]==nums[i+1]){tong++;i++;}
            if(i<nums.length-1){
                if((nums[i]<nums[i-1-tong]&&nums[i]<nums[i+1])
                        ||(nums[i]>nums[i-1-tong]&&nums[i]>nums[i+1])) {
                    count++;
                }
            }
            if(i==nums.length-1){
                if((nums[i]<nums[i-1-tong])
                        ||(nums[i]>nums[i-1-tong])){
                    count++;
                }
            }
        }

        return count;
    }
}
