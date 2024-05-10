package leetcode;

public class l38_1 {
    //官方题解
    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {

            int start = 0;
            int pos = 0;
            StringBuilder sb  = new StringBuilder();
            while (pos<str.length()){
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(pos - start).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }
}
