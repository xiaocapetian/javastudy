package leetcode300;

public class l392 {
    public boolean isSubsequence(String s, String t) {
//自己写的,性能很好
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int j = -1;
        for(int i = 0;i<sarr.length;i++){
            j++;//就算相同j也要++一次啊
            while (j<tarr.length&&sarr[i]!=tarr[j]){
                j++;
            }
            if(j==tarr.length)return false;
        }
        return true;
    }
}
