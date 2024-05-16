package leetcode2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l2580 {
    static final int MOD = 1000000007;
    public int countWays(int[][] ranges) {

        Arrays.sort(ranges,(o1, o2) -> {
            if(o1[0]!=o2[0])return o1[0]-o2[0];
            return o1[1]-o2[1];
        });
        int res = 1;
        //List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            if(i+1<ranges.length&&ranges[i][1]>=ranges[i+1][0]){
                //ranges[i+1][0]=ranges[i][0];
                ranges[i+1][1] = Math.max(ranges[i+1][1],ranges[i][1]);
            }else {
                //list.add(ranges[i]);
                res = res*2%MOD;
            }
        }
//        for (int[] ints : list) {
//            System.out.println(Arrays.toString(ints));
//        }
        return res ;
    }
}
