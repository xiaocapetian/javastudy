package leetcode300;

public class l383 {
    //和l242差不多!!别学了就忘啊!!!
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] hash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            hash[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            hash[ransomNote.charAt(i)-'a']--;
            if(hash[ransomNote.charAt(i)-'a']<0)return false;
        }
        return true;
    }
}
