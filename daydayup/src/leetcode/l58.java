package leetcode;

public class l58 {
    //简单的意义不明的题
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        int res = 0;
        while (s.charAt(i)==' '){i--;}

        for ( ;i >=0&&s.charAt(i)==' '; i--) {
            res++;
        }
        return res;
    }
}
