package leetcode400;

import java.util.Arrays;

public class l455v2 {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);//child
        Arrays.sort(s);//饼干
        int cookieItem = s.length-1;
        int count=0;
        for (int childItem = g.length-1;childItem>=0;childItem--){
            if (cookieItem>=0&&g[childItem]<=s[cookieItem]){
                cookieItem--;
                count++;
            }
        }
        return count;
    }
}
