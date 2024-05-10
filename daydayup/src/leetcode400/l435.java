package leetcode400;

import java.util.Arrays;

public class l435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->{
            return o1[0]-o2[0];
        });
        int res = 0;
        if(intervals.length==1){return 0;}
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]>=intervals[i-1][1]){

            }else {
                res++;
                //更新策略:取小的那个!
                intervals[i][1] = Math.min(intervals[i-1][1],intervals[i][1]);
            }
        }
        return res;

    }
}
