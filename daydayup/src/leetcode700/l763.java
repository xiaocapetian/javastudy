package leetcode700;

import java.util.ArrayList;
import java.util.List;

public class l763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[26];//记录每个字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']=i;
        }
        int end = 0;int start=0;
        for (int i = 0;i<s.length();i++){//对s一个一个遍历就行了
            end = Math.max(end,hash[s.charAt(i)-'a']);//看看end能冲多远
            if(i==end){    //这题不就是类似那个公路题吗?!?  //撞上了说明有那种"收敛"的感觉了
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;
    }

    /**
     *我自己写的但是不成功
     * @param s
     * @return
     */
    public List<Integer> partitionLabels_old(String s) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            int jrange=i;//下一个区间能走多远
            for (int j = i;j<=jrange&&j<=s.length()-1;j++){

                int reverseLookup = s.length()-1;
                while (reverseLookup>j&&s.charAt(reverseLookup)!=s.charAt(j)){
                    reverseLookup--;}
                jrange = reverseLookup;
            }

            res.add(jrange-i);
            i=jrange+1;
        }

        return res;
    }
}
