package leetcode500;

import java.util.*;

/**
 * 本题的解题思路是，找len最长的str.如果最长的str没有重复，那它（的长度）就是答案，
 * 如果所有并列最长的都有重复了，
 * （按顺序）依次对次长的做，如果次长的不是任一最长的子序列，那么这个次长的（的长度）就是答案
 *                      如果是某个最长的子序列话，那之后也不需要再考虑这个次长的了（为什么，后面的只要不是最长者的子序列，自然不是次长的子序列）
 * 这个思路正确，但是太复杂
 */
public class l522 {
    /**
     * @param strs 给定字符串列表 strs ，
     * @return 返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。

     * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
     *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
     * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
     *
     */
    public int findLUSlength(String[] strs) {

        Arrays.sort(strs, (o1, o2) -> {return o2.length()-o1.length();});
        //直到最长者的长度
        int maxlen = strs[0].length();
        Set<String> longestStrs= new HashSet<>();

        //Set<String> notLongStrs= new HashSet<>();
        PriorityQueue<String> notLongpq = new PriorityQueue<>((o1, o2) -> {return o2.length()-o1.length();});
        //String pre;
        //做一个map,统计每个str出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], map.getOrDefault(strs[i], 0) + 1);
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if(stringIntegerEntry.getKey().length()==maxlen){
                if(stringIntegerEntry.getValue()==1){return stringIntegerEntry.getKey().length();}//如果最长的没有重复
                longestStrs.add(stringIntegerEntry.getKey());//否则加到list最长名单里来
            }else if (stringIntegerEntry.getValue()==1){//非最长如果还重复就没有用
                notLongpq.add(stringIntegerEntry.getKey());
            }
        }
        System.out.println(longestStrs);
        System.out.println(notLongpq);
        System.out.println(map);

        //如果最长的有重复
        //对普通的遍历
        for (String notLongStr : notLongpq) {
            //如果普通的重复
            if(map.get(notLongStr)>1)continue;
            boolean flag =true;
            //如果没重复，且不是任何一个最长的子集
            for (String longestStr : longestStrs) {
                if(ischild(notLongStr,longestStr)){flag=false;break;}
            }
            if(flag){return notLongStr.length();}
        }

        return -1;
    }

    /**
     * str1是 str2的子序列吗？
     */
    private boolean ischild(String str1, String str2) {
        int item2 = 0;
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            //System.out.println("i="+i+",c ="+c);
            while (item2<str2.length() && c != str2.charAt(item2)) {
                //System.out.println("item2="+item2);
                item2++;
            }

            if(item2==str2.length()){return false;}
            item2++;
        }
        return true;
    }
}
