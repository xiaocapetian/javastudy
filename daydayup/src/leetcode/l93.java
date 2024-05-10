package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l93 {
    //自己写的,就是速度慢
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
    public static List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        backtrack(s,res,new StringBuilder(),0,0);
        return res;
    }
    public static void backtrack(String s,List<String> res,StringBuilder path,int startItem,int count){
        System.out.println("path= "+path);
        if(startItem==s.length()&&count==3){
            res.add(path.toString());
            return;
        }

        for (int i = startItem;i<startItem+3&&i<s.length();i++){
            String num = s.substring(startItem, i + 1);
            //打的点小于3,数字小于255,要么第一位不是0要么长度只有一位
            if(count<=3&&Integer.parseInt(num)<=255&&(num.charAt(0)!='0'||num.length()==1)) {
                if (path.length() == 0) {
                    path.append(s.substring(startItem, i + 1));
                    count++;
                } else {
                    path.append(".").append(s.substring(startItem, i + 1));
                    count++;
                }
            }else {return;}

            backtrack(s,res,path,i+1,count);

            //能否找到一个".",如果找到,删掉它和它之后的部分,如果不能,说明要删的是第一位,故删掉全部
            path.delete(path.lastIndexOf(".")!=-1?path.lastIndexOf("."):0,path.length());
            count--;

        }
    }
}
