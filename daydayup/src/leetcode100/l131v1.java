package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 我厉害了 首先先来个l5
 */
public class l131v1 {
    List<List<String>> res = new ArrayList<>();
    boolean[][] bp;
    public List<List<String>> partition(String s) {
        char[] sarr = s.toCharArray();
        bp = new boolean[sarr.length][sarr.length];
        //bp[i][j]是从i开始到j止是否是回文子串
        for (int j = 0;j<s.length();j++){
            for (int i = 0;i<=j;i++){ /*[易错]👇这里考虑清楚*/
                //for (int i = j;i<s.length();i++){
                if(i==j){bp[i][i] = true;}
                else if(i==j-1){
                    if(sarr[i]==sarr[i+1]){bp[i][i+1] =true;}

                }else {
                    if(sarr[i]==sarr[j]&& bp[i + 1][j - 1]){bp[i][j] = true;}
                }
            }
        }
        backtrack(s,0,new ArrayList<>());
        return res;
    }
    public void backtrack(String s,int startItem,List<String> path){
        System.out.println(path);
        if(startItem==s.length()){
            List<String> result =new ArrayList<>(path);
            res.add(result);
            return;}
        for(int i = 0;startItem+i<s.length();i++){
            //👆我这写清晰啊,i就是从startItem后面加几个
            if(bp[startItem][startItem+i]){
                //从startItem到startItem+i是回文
                path.add(s.substring(startItem,i+startItem+1));
                backtrack(s,i+startItem+1,path);
                path.remove(path.size()-1);
            }
        }
    }
}
