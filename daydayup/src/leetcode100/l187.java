package leetcode100;

import java.util.*;

public class l187 {
    /**
     *简单容易的解法
     * @param s 给定一个表示 DNA序列 的字符串 s
     * @return 返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
     */
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(int i = 0;i+10<=s.length();i++){/*[易错]这里应该是<=*/
            String ssub = s.substring(i, i + 10);
            if(set.contains(ssub)){
                if(!res.contains(ssub)){
                    res.add(ssub);
                }

            }else {
                set.add(ssub);
            }
        }
        return res;
    }



}
