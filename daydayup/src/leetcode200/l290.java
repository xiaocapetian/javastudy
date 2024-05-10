package leetcode200;

import java.util.HashMap;

public class l290 {
    public boolean wordPattern(String pattern, String s) {

        HashMap<String,String> hash =new HashMap<>();
        String[] patternarr = pattern.split("");
        String[] sarr = s.split(" ");
        if(patternarr.length!=sarr.length){return false;}
        for (int i = 0; i < sarr.length; i++) {
            if(hash.containsKey(patternarr[i])){
                if(!hash.get(patternarr[i]).equals(sarr[i])){return false;}
            }else {
                if(hash.containsValue(sarr[i])){return false;}//这个不能漏了
                hash.put(patternarr[i],sarr[i]);
            }
        }
        return true;
    }
}
