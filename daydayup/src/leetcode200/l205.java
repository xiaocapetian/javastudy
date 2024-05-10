package leetcode200;

import java.util.HashMap;

public class l205 {
    //自己写的还挺快的,,,
    public boolean isIsomorphic(String s, String t) {
        //int[]
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char scur = s.charAt(i);
            char tcur = t.charAt(i);
            if(map.containsKey(scur)){
                if(tcur!=map.get(scur)){return false;}
            }else {
                if(map.containsValue(tcur)){return false;}
                else {
                    map.put(scur,tcur);
                }
            }
        }
        return true;
    }
}
