package leetcode200;

import java.util.HashMap;
import java.util.Map;

public class l242 {//自己写的,我建了一个HashMap,速度很慢
    public static void main(String[] args) {
        isAnagram("anagram3","nagaram4");
    }
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        //s就往上加,t就往下减,别笑死我了
        if(s.length()!=t.length())return false;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i),value+1);
                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
            }else {
                map.put(s.charAt(i),1);
            }
            if(map.containsKey(t.charAt(i))){
                int value = map.get(t.charAt(i));
                map.put(t.charAt(i),value-1);
                if(map.get(t.charAt(i))==0){
                    map.remove(t.charAt(i));
                }
            }else {
                map.put(t.charAt(i),-1);
            }
        }

        //System.out.println(map);
        return map.isEmpty();
    }
}
