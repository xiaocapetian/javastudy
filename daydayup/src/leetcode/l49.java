package leetcode;

import java.util.*;

public class l49 {
    //建一个哈希表,键是排序后的string,值是一个list,存符合的string
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)){
                map.get(key).add(str);}
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);}
        }
        //Collection<List<String>> values = map.values();
        List<List<String>> res = new ArrayList<>(map.values());

        return res;
    }
}
