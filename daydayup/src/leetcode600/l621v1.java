package leetcode600;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 改一改之后速度快多啦~~
 */
public class l621v1 {
    public int leastInterval(char[] tasks, int n) {

        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i]-'A']++;
        }
        Arrays.sort(map);
        //注意,只有对Integer[]排序才可以自定义排序规则!!!  int[]是不可以的!!!
/*        Integer[] map2 = new Integer[26];
        Arrays.sort(map2,(o1, o2) -> {
            return o2-o1;
        });*/

        int i = 24;
        while (i>=0&&map[i]==map[25]){
            i--;
        }
        int nummax = 25-i;
        int max = map[25];
        return Math.max((max-1)*(n+1)+nummax,tasks.length);
    }
}
