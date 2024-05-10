package leetcode700;

public class l738v1 {
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int start = s.length();
            for (int i = s.length() - 2; i >= 0; i--) {
                if (chars[i] > chars[i + 1]) {
                    chars[i]--;
                    start = i+1;
                }
            }
            for (int i = start; i < s.length(); i++) {
                chars[i] = '9';
            }
            return Integer.parseInt(String.valueOf(chars));
        }


        public int monotoneIncreasingDigits_old(int N) {
            String[] strings = (N + "").split("");
            int start = strings.length;
            for (int i = strings.length - 1; i > 0; i--) {
                if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                    strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                    start = i;
                }
            }
            for (int i = start; i < strings.length; i++) {
                strings[i] = "9";
            }
            return Integer.parseInt(String.join("",strings));
        }
    }
}
