package leetcode400;

import java.util.Arrays;

public class l455v3 {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);//child
        Arrays.sort(s);//饼干
        int cookieItem = 0;
        int count=0;
        for (int childItem = 0;childItem< g.length;childItem++){
            while (cookieItem<s.length&&g[childItem]>s[cookieItem]){
                cookieItem++;
            }
            if (cookieItem<s.length&&g[childItem]<=s[cookieItem]){
                cookieItem++;
                count++;
            }

        }
        return count;
    }
}
