package leetcode;
//抄了动态规划
public class lcode_5_1 {
    public static void main(String[] args) {
        String s = "abcda";
        String ss = longestPalindrome(s);
        System.out.println(ss);

    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if( len == 1 ){
            return s;
        }
        if( len == 2 ){
            if(s.charAt(0)==s.charAt(1)){return s;}
            else{return s.substring(0,1);}
        }
        int begin = 0;
        int max = 1;
        boolean[][] dp = new boolean[len][len];
        /*===========================
        dp[i][j]表示i到j的字符串是否是回文
        * */

        //初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chararray = s.toCharArray();
        for (int L= 2; L <= len; L++){//L是子串长度
            for (int i = 0; i <len-1; i++) {//i是左边界
                int j = i+L-1;
                if(j>=len){break;}
                if(chararray[i]!=chararray[j]){
                    dp[i][j] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        //if(dp[i+1][j-1]){dp[i][j] = true;}
                        //else {dp[i][j] = false;}
                        dp[i][j] = dp[i + 1][j - 1];//不要像上面这么写
                    }
                }
                if(dp[i][j]&&max<L){
                    max = L;
                    begin = i;
                }
            }
        }
        //
        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[i].length; i1++) {
                System.out.print(dp[i][i1]+" ");
            }
            System.out.println();

        }

        return s.substring(begin, begin + max);

    }


}
