package leetcode400;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class l424 {
    public int characterReplacement(String s, int k) {

        //int[][] map = new int[26][s.length()];
        List<Integer>[] lops = new ArrayList[26];
        for (int i = 0; i < lops.length; i++) {
            lops[i] = new ArrayList<>();
        }
        int[] has =new int[26];
        for (int i = 0; i < s.length(); i++) {
            lops[s.charAt(i)-'A'].add(i);
            has[s.charAt(i)-'A']++;
        }
        int res = 0;

        for (List<Integer> lop : lops) {
            int left = 0;
            int right = 0;

            while (right<lop.size()){
                int numtoDelete = lop.get(right)- lop.get(left)-(right-left);
                //假设要删1个,但是k=2,那就还能再加k-numtoDelete个

                while (numtoDelete>k){
                    left++;
                    numtoDelete = lop.get(right)- lop.get(left)-(right-left);
                }
                int add = k-numtoDelete;
                //res = Math.max(res,lop.get(right)- lop.get(left)+1+add);
                //不对,不能超过s.的长度这个极值
                res = Math.max(res,Math.max((lop.get(right)- lop.get(left)+1+add),s.length()));
                right++;
            }
        }
        return res;
    }
}
