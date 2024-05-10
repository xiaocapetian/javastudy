package leetcode200;

public class l274v1 {
    //根据l274改的二分查找版本 ,速度超级快
    public int hIndex(int[] citations) {
        //Arrays.sort(citations);
        //int h = citations.length;
        int left = 0;
        int right = citations.length;
        int mid=0;
        while (right>=left){
            mid = left + (right - left) / 2;
            //如果中间值不可以,中间值的上一个可以,  或  中间值不可以且中间值==0
            if(!canThisH(citations,mid)&&(mid == 0 ||canThisH(citations,mid-1))){
                return mid-1;//那中间值的上一个就是答案
            }else if(canThisH(citations,mid)){ //中间值可以,继续尝试
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return mid;//说明最大的都可以,

    }

    public boolean canThisH (int[] citations,int h){
        int noH = 0;
        for (int citation : citations) {
            if(citation<h){
                noH++;
                if(noH>citations.length-h){return false;}
            }

        }
        return true;
    }
}
