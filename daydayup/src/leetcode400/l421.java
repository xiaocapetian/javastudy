package leetcode400;

import java.util.HashMap;
import java.util.Map;

public class l421 {
    public int maxProduct(String[] words) {
        Map<Integer,Integer> map = new HashMap<>();
        for (String word : words) {

            //对每个单词都生成一个t,代表字母频率
            int t = 0;
            for (int j = 0; j < word.length(); j++) {
                //第i位的字母序号
                int u = word.charAt(j) - 'a'; //如果是'a'就移动0位,是'b'就移动1位
                t |= (1 << u);
            }
            if (!map.containsKey(t) ||
                    //words[map.get(t)].length()<words[i].length()){
                    map.get(t) < word.length()) {
                map.put(t, word.length());
            }
        }
        int res = 0;
/*        for (Map.Entry<Integer, Integer> e1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> e2 : map.entrySet()) {
                if((e1.getKey()&e2.getKey())==0){
                    //说明两者没有相同的字符
                    res = Math.max(res,e1.getValue()*e2.getValue());
                }
            }
        }*/
        //这样快一点
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if ((a & b) == 0) res = Math.max(res, map.get(a) * map.get(b));
            }
        }
        return res;
    }
}
