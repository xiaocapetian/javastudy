package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 其实v1的双指针可能更清晰一点
 */
public class l56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(o1,o2)->{return o1[0]-o2[0];});
        res.add(intervals[0]);//先放一个进去
        if(intervals.length==1){return intervals;}
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>intervals[i-1][1]){//不会重叠
                res.add(intervals[i]);
                //大胆的把这位放进去
            }else {//重叠了

                intervals[i][1] = Math.max(res.get(res.size()-1)[1],intervals[i][1]);
                //首先1: 要修改数组, 数组i位[1]第二位换成res里的最大值(这是针对i位[1]比之前的[1]还要小)
                res.set(res.size()-1,
                        new int[]{res.get(res.size()-1)[0],intervals[i][1]});
                //(这是针对i位[1]比之前的[1]还大),[1]改成新版本的, [0]还是取旧版本的
            }


        }
        int[][] result = res.toArray(new int[res.size()][]);
        return result;
    }
}
