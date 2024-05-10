package leetcode;

import java.util.Arrays;

public class lcode_5v2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {//0,1
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度
        /*===========================
        dp[i][j]表示i到j的字符串是否是回文
        * */
        boolean[][] dp = new boolean[strLen][strLen];
//为什么先遍历j后遍历i?很容易理解吧
        for (int j = 1; j < strLen; j++) {
            for (int i = 0; i < j; i++) {
                //注意这里初始化和和后面的写一起了  如果不写一起看下面👇
                if (s.charAt(i) == s.charAt(j) //
                        && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxStart = i;
                        maxEnd = j;

                    }
                }

            }

        }
        for (int i = 0; i < strLen; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return s.substring(maxStart, maxEnd + 1);

    }

//    作者：reedfan
//    链接：https://leetcode.cn/problems/longest-palindromic-substring/solutions/63641/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {//0,1
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度
        /*===========================
        dp[i][j]表示i到j的字符串是否是回文
        * */
        boolean[][] dp = new boolean[strLen][strLen];
        for (int j = 0; j < strLen; j++){
            dp[j][j]=true;
        }
        for (int i = 0; i < strLen-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1]=true;
                maxLen =  1;
                maxStart = i;
                maxEnd = i+1;
            }

        }
//为什么先遍历j后遍历i?很容易理解吧
        for (int j = 1; j < strLen; j++) {
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]==true) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxStart = i;
                        maxEnd = j;

                    }
                }

            }

        }
        for (int i = 0; i < strLen; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return s.substring(maxStart, maxEnd + 1);

    }
}
/*[false, false, false, false]
[false, false, true, false]
[false, false, false, false]
[false, false, false, false]
* */
//自己写的longestPalindrome2会考虑对角线
/*[true, false, false, false]
[false, true, true, false]
[false, false, true, false]
[false, false, false, true]
* */