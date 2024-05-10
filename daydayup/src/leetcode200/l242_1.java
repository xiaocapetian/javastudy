package leetcode200;

public class l242_1 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagramo","nagaramp"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;//判断长度其实会慢
        int[] hash = new int[26];//直接一个[26]的数组!!!
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }
        for (int j : hash) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}

