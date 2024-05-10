package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己写的,快倒是快,就是很多细节不容易一次性写出来
 */
public class l57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int l1=0;
        List<int[]> reslist = new ArrayList<>();
        //完全在newInterval左边的,放进去
        while (l1<intervals.length&&intervals[l1][1]<newInterval[0]){
            reslist.add(intervals[l1]);
            l1++;
        }
        //newInterval可能要修改[易错1]
        if(l1<intervals.length){
            newInterval[0] = Math.min(newInterval[0],intervals[l1][0]);}
        //有多少的右边能包在newInterval里的
        while (l1<intervals.length&&intervals[l1][1]<=newInterval[1]){
            l1++;
        }
        //此时有3种可能,1.intervals弄完了,2.右边包不住,左边重叠,3.左边也大于 脱离的,
        if(l1==intervals.length){
            reslist.add(newInterval);
            int[][] res = new int[reslist.size()][2];
            for (int i = 0; i < res.length; i++) {
                res[i] = reslist.get(i);
            }
            return res;
        }
        //左边也大于newInterval,脱离的,
        if(newInterval[1]<intervals[l1][0]){
            reslist.add(newInterval);
        }else {
            //2.右边包不住,左边重叠,
            intervals[l1][0]=newInterval[0];
        }

        while (l1<intervals.length){
            reslist.add(intervals[l1]);
            l1++;
        }
        int[][] res = new int[reslist.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = reslist.get(i);
        }
        return res;

    }


}
