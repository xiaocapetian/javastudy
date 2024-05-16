package leetcode600;

import java.util.*;

/**
 * 思路简单自己想出来的,速度慢,但是可以过
 */
public class l621 {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        /*[重难点]一个数组怎么求出现次数最多的元素?可以用map来统计,然后用
        * Collections.max()往里面塞进去一个集合,可求value的最大值maxvalue
        * 然后再遍历一遍map,所有value==maxvalue都可
        *
        * */
        Integer max = Collections.max(map.values());
        //Collection<Integer> values = map.values();
        //List<Character> maxlist = new ArrayList<>();
        int nummax = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if(characterIntegerEntry.getValue().equals(max)){
                nummax++;
            }
        }
        //System.out.println(max);
        return Math.max((max-1)*(n+1)+nummax,tasks.length);
    }
}
