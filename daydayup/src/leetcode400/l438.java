package leetcode400;

import java.util.ArrayList;
import java.util.List;

public class l438 {
    /*其实思路想到了,大胆列两个数组,然后比就完了*/
    public List<Integer> findAnagrams(String s, String p) {
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();

        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length()){return res;}
        int left = 0;
        int right = 0 ;
        //int right = p.length()-1;
        int[] biao = new int[26];
        int[] pbiao = new int[26];
        for (int i = 0; i < parr.length; i++) {
            pbiao[parr[i]-'a']++;
        }

        while (right<p.length()){
            biao[sarr[right]-'a']++;
            right++;
        }
        if(judge(biao,pbiao)){res.add(0);}
        for (; right<s.length(); left++,right++) {
            biao[sarr[left]-'a']--;
            biao[sarr[right]-'a']++;
            if(judge(biao,pbiao)){res.add(left+1);}
            //                             for (int i : biao) {
            //     System.out.print(i+",");
            // }
            // System.out.println();
        }
        return res;

    }
    public boolean judge(int[] biao,int[] pbiao){
        for (int i = 0; i < biao.length; i++) {
            if(biao[i]!=pbiao[i]){return false;}
        }
        return true;
    }

}
