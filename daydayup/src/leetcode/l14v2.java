package leetcode;

import java.util.Arrays;

/**
 * 先排序，再比第一位和最后一位
 */
public class l14v2 {

    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        if(strs[0].isEmpty()){return "";}
        int item = 0;
        while (item<strs[0].length()&&strs[0].charAt(item)==strs[strs.length-1].charAt(item)){
            item++;
        }
        //0 ~ i-1位是相等的
        return strs[0].substring(0, item);
    }
}
