package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路清晰又简单
 * [重点]对于中间第二类,不用细分是左重叠,右重叠还是包含,,只要不是第一三类,就和newInterval搞合并
 */
public class l57v1 {
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int l1=0;
        List<int[]> reslist = new ArrayList<>();
        //分成3类
        //第一类:完全在newInterval左边的,放进去
        while (l1<intervals.length&&intervals[l1][1]<newInterval[0]){
            reslist.add(intervals[l1]);
            l1++;
        }
        //对于中间第二类,不用细分是左重叠,右重叠还是包含,,只要不是第三类,就和newInterval搞合并
        while (l1<intervals.length&&newInterval[1]>=intervals[l1][0]){
            newInterval[0]=Math.min(newInterval[0],intervals[l1][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[l1][1]);
            l1++;
        }
        reslist.add(newInterval);

        //第三类:完全在newInterval右边的,放进去
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
