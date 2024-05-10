package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class l76v1 {
    Map<Character, Integer> tmap = new HashMap<Character, Integer>();
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && tmap.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (tmap.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
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
}
