package leetcode;

import java.util.HashMap;
import java.util.Map;

public class l76v2 {
    /*真高级啊,疯狂加注释才看懂*/
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int right = 0, left = 0;
        int valid = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            // 进行窗口数据一系列更新
            // 如果窗右侧的字母 是 目标里的字母
            System.out.println("现在看cur:"+cur+"在不在tmap里");
            if (tmap.containsKey(cur)) {
                //把它放进map
                System.out.println(cur+"在tmap里,现在要把cur:"+cur+"放进map了");
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                //如果现在map里的该字母数值==目标的数值
                System.out.println("现在比较map.get(cur):"+map.get(cur)+",和tmap.get(cur):"+tmap.get(cur));
                if (map.get(cur).equals(tmap.get(cur))) {

                    valid++;
                    System.out.println("valid++了现在是"+valid);
                }
            }
            System.out.println("tmap.size()是"+tmap.size()+",valid是"+valid+"比较是否相等");
            //tmap.size()是tmap总共有多少字母?
            //当valid的值等于tmap的大小时，表示当前窗口包含了t中所有字符的正确数量，可以满足题目要求，因此我们可以进行相应的操作（比如更新最小子串的长度）
            while (tmap.size() == valid) {
                System.out.println("tmap.size() == valid,现在都= "+tmap.size());
                if (right - left < minLen) {
                    System.out.println("right - left < minLen,现在更新最小值");
                    start = left;
                    minLen = right - left;
                }
                // d 是即将移除窗口的字符串
                char d = s.charAt(left);
                System.out.println("即将移除窗口的字符串是"+d+"现在left是"+left);
                // 左边移动窗口
                left++;
                // 进行窗口内数据当一系列更新
                if (map.containsKey(d)) {
                    System.out.println("map含有d(d是"+d);
                    System.out.println("map.get(d)是"+map.get(d)+"tmap.get(d)是"+tmap.get(d));
                    if (map.get(d).equals(tmap.get(d))) {
                        valid--;
                        System.out.println("map.get(d).equals(tmap.get(d))成立,valid--,减之后是"+valid);
                    }
                    //移除窗口了,那该值-1很合理吧
                    map.put(d, map.get(d) - 1);
                    System.out.println("d是"+d+",减1,现在map.get(d)是"+map.get(d));
                }
            }
        }


        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
