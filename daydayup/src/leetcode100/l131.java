package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 二刷v1明显有进步哇!
 */
public class l131 {
    public static void main(String[] args) {
        System.out.println(partition("aaabbcbbc"));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        //char[] chararray = s.toCharArray();//字符串变字符数组
        backtrack(s,res,new ArrayList<>(),0);
        return res;
    }
    public static void backtrack(String s,List<List<String>> res,List<String> path,int startItem){

        System.out.println("path= "+path);

        if(s.length()==startItem){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startItem;i<s.length();i++){
            //i就是字串往后加几个!切字串的切割线
            String zichuan = s.substring(startItem,i+1);//这一步太难了!!
            System.out.println("判断子串"+zichuan+"是不是回文");
            if(ishuiwen(zichuan)){//判断这个字串是不是回文串,如果不是不继续了,可以把这个注释调,那就是全部的字串
                path.add(zichuan);
                //怎么思考?
                System.out.println("这个时候startItem="+startItem+" ,i="+i+" ,刚刚加入的串是"+s.substring(startItem,i+1));
                backtrack(s,res,path,i+1);
                System.out.println("撤销上一步的"+path.get(path.size()-1));
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean ishuiwen(String s){
        for (int i = 0; i <= s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
