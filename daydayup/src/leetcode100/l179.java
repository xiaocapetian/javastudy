package leetcode100;

import java.util.Arrays;
import java.util.Comparator;

public class l179 {
    /**自己写的,还不错哦
     *
     * @param nums 给定一组非负整数 nums，
     * @return 重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     */
    public String largestNumber(int[] nums) {

        String[] strnums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strnums[i] = nums[i]+"";
        }
        //就是这个排序嘛
        Arrays.sort(strnums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0;
                String oo1 = o1+o2;
                String oo2 = o2+o1;
                /*重难点: 这里直接拼接就好!!!别担心有的没的,哪个短哪个长,一直相等怎么比下去 等等*/
                while (i<oo1.length()){
                    int b1,b2;
                    b1 = oo1.charAt(i);
                    b2 = oo2.charAt(i);
                    if(b1!=b2){return b2-b1;}
                    else {i++;}
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(strnums));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strnums.length; i++) {
            sb.append(strnums[i]);
        }
        String res = sb.toString();
        if(res.charAt(0)=='0')return "0";
        else {return res;}

    }
}
