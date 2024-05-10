package leetcode400;

import java.util.Arrays;
import java.util.LinkedList;

public class l406 {
    public int[][] reconstructQueue(int[][] people) {
/*这个排序听老师分析,怎么思考,
要按身高从大到小排,有什么好处,后面小个子要因为前面的人多了而往前面插时,不影响前面的人的 前面有几个比他高
* */
        /*代码内容完全是抄的*/
        //数组排序得练习!!!
        Arrays.sort(people,(o1,o2)->{
            if(o1[0]==o2[0])return o1[1]-o2[1];
            return o2[0]-o1[0];
        });

        //这个插入方法得学习!!
        //而且为什么可以直接插入也是思考出来的!!
        LinkedList<int[]> linkedList = new LinkedList<>();
        for (int[] p : people) {
            linkedList.add(p[1],p);
        }
        //这个linkedList转换Array方法得学习!!!
        return linkedList.toArray(new int[people.length][]);
    }
}
