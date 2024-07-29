package leetcode300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*[重难!!!]这里最后一步,一定要回溯,一定要把path的删掉,然后回到上一层*/
public class l301 {
    /**
     * 既然要把所有的结果列出来,不用想什么动规了,肯定上回溯!
     * 其实不难呀!!!
     * 这里的回溯额有个小创新,就是如果发现了有更大的,就清空
     * @param s
     * @return
     */
    int maxnum;
    public List<String> removeInvalidParentheses(String s) {

        int leftnum = 0;
        int rightnum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')leftnum++;
            else if(s.charAt(i) == ')'){rightnum++;}
        }
        int max = Math.min(leftnum,rightnum);
        Set<String> res = new HashSet<>();


        dfs(s,0,res,0,max,new StringBuilder());
        //System.out.println(res);
        List<String> reslist = new ArrayList<>();
        for (String re : res) {

            reslist.add(re);

        }
        return reslist;
    }

    private void dfs(String s, int index, Set<String> res, int leftcount, int max, StringBuilder path) {
        //System.out.println(path+" ,leftcount="+leftcount);
        if(leftcount<0||leftcount>max){return;}
        if(index==s.length()){
            if(leftcount==0){
                if(path.toString().length()>maxnum){
                    //System.out.println(path+"maxnum="+maxnum);
                    maxnum=path.toString().length();
                    res.clear();
                    res.add(path.toString());

                }else if(path.toString().length()==maxnum){
                    res.add(path.toString());
                }else{

                }


            }
            return;
        }
        if (s.charAt(index)=='('){
            path.append('(');
            dfs(s,index+1,res,leftcount+1,max,path);
            path.deleteCharAt(path.length()-1);
            dfs(s,index+1,res,leftcount,max,path);
        }else if(s.charAt(index)==')'){
            path.append(')');
            dfs(s,index+1,res,leftcount-1,max,path);
            path.deleteCharAt(path.length()-1);
            dfs(s,index+1,res,leftcount,max,path);
        }else {
            path.append(s.charAt(index));
            dfs(s,index+1,res,leftcount,max,path);
            path.deleteCharAt(path.length()-1);
            /*[重难!!!]这里最后一步,一定要回溯,一定要把path的删掉,然后回到上一层*/
        }

    }
}
