package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * //24.4.17二刷
 * [易错1]这里是>=不是>
 * [易错2]  最后还要把left的东西写入一次
 *
 * [难点1] 这题要想双指针
 * [难点2]  list转arr
 * int[][] resarr = res.toArray(new int[res.size()][2]);
 */
public class l56v1 {
    public int[][] merge(int[][] intervals) {

        int left = 0;
        int right = 0;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(o1, o2) -> {
            if(o1[0]!=o2[0]){return o1[0]-o2[0];}
            else {return o1[1]-o2[1];}
        });
//        for (int[] interval : intervals) {
//            System.out.println(Arrays.toString(interval));
//        }

        for (;right<intervals.length;right++){
            /*[易错1]这里是>=不是>  为什么呢?l1==r1应该怎么办?肯定是让r继续走啊*/
            if(intervals[left][1]>=intervals[right][1]){//l1>=r1  那自自然l1>r0
                continue;
            }
            else if(intervals[left][1]<intervals[right][1]&&intervals[left][1]>=intervals[right][0]){//l1<r1  l1>r0
                intervals[left][1] = intervals[right][1];
            }
            else {//l2<r1
                res.add(new int[]{intervals[left][0],intervals[left][1]});
                left = right;
            }
        }
        /*[易错2] 这里最后还要把left的东西再写入一次*/ //因为这里我们的思路是后把left的东西写入
        res.add(new int[]{intervals[left][0],intervals[left][1]});

        int[][] resarr = res.toArray(new int[res.size()][2]);
        //int[][] resarr = new int[][]
        return resarr;
    }
}
