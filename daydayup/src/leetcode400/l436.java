package leetcode400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l436 {
    /**
     * @param intervals 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
     * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。注意 i 可能等于 j 。
     * @return  返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
     */
    public int[] findRightInterval(int[][] intervals) {
        int[][] leftItem = new int [intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            //记录每一个区间的左端点和下标
            int[] arr = new int[]{intervals[i][0],i};
            leftItem[i] = arr;
        }
        int[] res = new int[intervals.length];
        Arrays.sort(leftItem,(o1, o2) -> {return o1[0]-o2[0];});
        for (int i = 0; i < intervals.length; i++) {

            int youItem = intervals[i][1];
            int xiabiao = erfencha(youItem, leftItem, intervals);
            res[i] = xiabiao;
        }
        return res;
    }

    private int erfencha(int youItem, int[][] leftItem,int[][] intervals) {
        int left = 0;
        int right = intervals.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(leftItem[mid][0]==youItem){
                 return leftItem[mid][1];
            }else if (leftItem[mid][0]<youItem){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        /*[重难]👇一遍写对啦!*/
        //二分查找最后如果没找到,那最后的left就是应该填入的位置,
        //怎么记忆啊?其实是对称的,查找失败的时候,left在right的右边,此时left的左边,right的右边,应该夹着想找的数,由于新加的数会把右边的忘忧挤
        //所以left的位置会是要填入的位置
        if(left<intervals.length){return leftItem[left][1];}
        else {return -1;}

    }
}
