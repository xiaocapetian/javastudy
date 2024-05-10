package leetcode400;

import java.util.Arrays;

public class l455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);//child
        Arrays.sort(s);//饼干
        int index = s.length-1;
        int result = 0;
        for (int i = g.length-1; i >=0 ; i--) {
            if(index>=0&&s[index]>=g[i]){
                result++;
                index--;
            }
        }
        return result;

    }
}
