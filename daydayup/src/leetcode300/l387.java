package leetcode300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class l387 {
    /**
     * @param s 给定一个字符串 s ，
     * @return 找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     */
    public int firstUniqChar(String s) {

        //统计次数
        //HashMap<Character,Integer> map = new HashMap<>();
        //统计是否出现过
        //HashMap<Character,Boolean> map = new HashMap<>();
        //记录索引或-1（出现过）
        //HashMap<Character,Integer> map = new HashMap<>();
        int[] map = new int[26];
        char[] sarr = s.toCharArray();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < sarr.length; i++) {

            Character c = sarr[i];
            map[c-'a'] ++;
            if(map[c-'a']==1){queue.add(new Pair(i,c));}
        }

        while (!queue.isEmpty()){
            Pair poll = queue.poll();
            if(map[poll.c-'a']==1){return poll.suoyin;}
        }
        return -1;
    }
    class Pair{
        int suoyin;
        Character c;
        Pair(int suoyin,Character c){
            this.suoyin =suoyin;
            this.c = c;
        }
    }

    //法二 map记录索引,简洁多了,但是速度慢一些
    public int firstUniqCharV2(String s) {
        //记录索引或-1（出现过）
        HashMap<Character,Integer> map = new HashMap<>();
        char[] sarr = s.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            if(map.containsKey(sarr[i])){
                map.put(sarr[i],-1);
            }else {
                map.put(sarr[i],i);
            }
        }
        for (int i = 0; i < sarr.length; i++) {
            if(map.get(sarr[i])!=-1){
                return map.get(sarr[i]);
            }
        }
        return -1;
    }
}
