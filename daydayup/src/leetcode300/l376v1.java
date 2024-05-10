package leetcode300;

public class l376v1 {
    public int wiggleMaxLength(int[] nums) {

        if(nums.length==1)return 1;
        if(nums.length==2){
            if(nums[0]!=nums[1])return 2;
            else {return 1;}
        }
        int count = 1;
        int curDiff = 0;
        int preDiff = 0;
        for (int i = 0;i<nums.length-1;i++){
            curDiff = nums[i+1] - nums [i];
            if(preDiff>=0&&curDiff<0||preDiff<=0&&curDiff>0){
                /*这个能成立的细节,与上一个相同也算*/
                count++;
                preDiff = curDiff;//但是只在与上一个变符号转折的的时候才更新pre,
                //对于异号者,只要符号不变不影响,对于相同者,这个就很关键了!
            }
        }
        return count;
    }
}
