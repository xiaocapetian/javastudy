package leetcode200;

public class l274 {
    //自己写的但是太慢了,v1改了二分查找后就超级块了
    public int hIndex(int[] citations) {
        //Arrays.sort(citations);
        int h = citations.length;
        //int left;
        //int right;
        while (h>=0){
            if(canThisH(citations,h)){return h;}
            h--;
        }
        return 0;
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
