package leetcode;
//自己写的，又超出时间限制了QAQ
public class lcode_5 {
    public static void main(String[] args) {
        String s = "bb";
        String ss = longestPalindrome(s);
        System.out.println(ss);
    }
    public static String longestPalindrome(String s) {
        int max = 0;
        String result = "";
        String s2 = new String();

            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length(); j > i; j--) {

                    String s1 = s.substring(i,j);
                    if(huiwen(s1)&&max<j-i) {
                        max = j-i;

                        s2 = s1;

                    }

                }
            }

        return s2;
    }
    public static boolean huiwen(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
