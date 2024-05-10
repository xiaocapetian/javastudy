package leetcode400;

import java.util.Arrays;

public class l452 {

    //这题的关键是别纠结,气球边界排序,最后大胆改范围
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(o1,o2)->{
           //return o1[0]-o2[0];
            //为什么要这样改,因为有一个用例减法会越界
            if(o1[0]>=o2[0]){return 1;}
            else {
                return -1;
            }
        });
        int res = 1;
        if(points.length==1)return 1;
        for (int i = 1; i < points.length; i++) {
            //如果这个气球的左边界大于上一个气球的右边界
            if(points[i][0]>points[i+1][1]){
                res++;
            }else {
                //否则要把这个气球的右边界和上一个气球的 取一个最小值来覆盖
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }
        }

        return res;
    }
}
