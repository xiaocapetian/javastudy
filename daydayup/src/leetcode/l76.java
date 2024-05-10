package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class l76 {
    //if(minright>=0)最后这个>=想了半天才想到
    public String minWindow(String s, String t) {

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Map<Character,Integer> tmap = new HashMap<>();
        for (char c : tarr) {
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = -1; //让right从-1开始,这样就不用手动添加第一个了
        int minleft = 0;
        int minright = -1;
        int minlen = s.length()+1;
        Map<Character,Integer> map = new HashMap<>();
        //map.put(sarr[0],1);
        while (right<s.length()){
            if(jundgeMap(tmap,map)){

                if(right-left<minlen){
                    //System.out.println(left+","+right);
                    minlen = right-left;
                    minleft = left;
                    minright = right;
                }

                map.put(sarr[left],map.get(sarr[left])-1);
                left++;
            }
            else {
                right++;
                if(right<s.length()&&tmap.containsKey(sarr[right])){

                    map.put(sarr[right],map.getOrDefault(sarr[right],0)+1);
                }
            }
        }
        //System.out.println(left);
        //if(minright>=0){return s.substring(minleft,minright+1);}
        //else {return "";}
        return minlen!=s.length()+1?s.substring(minleft,minright+1):"";
    }
    //题解写的比较两个map是否相等速度更快!
    public boolean check(Map<Character,Integer> tmap,Map<Character,Integer> map) {
        //显式地使用了迭代器
        Iterator iter = tmap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (map.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
    public boolean jundgeMap(Map<Character,Integer> tmap,Map<Character,Integer> map){
        //System.out.println(map);
        //System.out.println(tmap);
        for (Map.Entry<Character, Integer> characterIntegerEntry : tmap.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            if(!map.containsKey(key)){
                return false;}
            else if(map.get(key)<characterIntegerEntry.getValue()){
                return false;
            }
        }
        return true;
    }

}
