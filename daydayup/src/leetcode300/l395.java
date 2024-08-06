package leetcode300;

import java.util.*;
/**
 * 自己想的方法，但是非常慢
 */
public class l395 {
    public int longestSubstring(String s, int k) {

        int res = 0;

        for(int i = 0;i<s.length();i++){
            //存现在有哪些
            Map<Character, Integer> map = new HashMap<>();
            //存不符合要求的
            Set<Character> no = new HashSet<>();
            //以第i位为终点，
            //发一个j向左，
            for(int j = i;j>=0;j--){
                if(!map.containsKey(s.charAt(j))){
                    no.add(s.charAt(j));
                }
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                if(map.get(s.charAt(j)) >= k){
                    no.remove(s.charAt(j));
                }
                if(no.isEmpty()){
                    res = Math.max(res,i-j+1);
                }
                //System.out.println(map);
                //System.out.println(no+"j-i+1="+(i-j+1));
            }
        }
        return res;
    }
}
