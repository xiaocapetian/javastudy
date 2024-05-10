package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lcode_3v2 {

    public int lengthOfLongestSubstring(String s) {
        // HashSet，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int n = s.length();
        // 右指针
        int right = 0, res = 0;
        for (int left = 0; left < n; ++left) {
            if (left != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(left - 1));
            }
            while (right  < n && !set.contains(s.charAt(right))) {//只要还没到头,以及右指的数在set里没有
                // 不断地移动右指针
                set.add(s.charAt(right));
                right++;
            }
            // 第 left 到 right 个字符是一个极长的无重复字符子串
            res = Math.max(res, right - left);//res,记最长记录
        }
        return res;


    }
}
