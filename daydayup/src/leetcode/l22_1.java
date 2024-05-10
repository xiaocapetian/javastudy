package leetcode;

import java.util.ArrayList;
import java.util.List;
//根据上一版自己改的，在生成res里加括号时就判断合法吗，好多了，但还是慢
public class l22_1 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuilder(),0,n);
        return result ;
    }
    public static void backtrack(List<String> result,StringBuilder res, int index,int n){
        //System.out.println("index= "+index+" res= "+res.toString()+" result= "+result);
        if(index==n*2){
            result.add(res.toString());
        }else {
            if(ifRightvalid(res.toString())&&ifLeftvalid(res.toString(),n)) {
                String[] strs = {"(", ")"};
                for (int i = 0; i < strs.length; i++) {

                    res.append(strs[i]);
                    backtrack(result, res, index + 1, n);
                    res.deleteCharAt(index);
                }
            }else if(ifRightvalid(res.toString())){
                res.append(')');
                backtrack(result, res, index + 1, n);
                res.deleteCharAt(index);
            }else if(ifLeftvalid(res.toString(),n)){
                res.append('(');
                backtrack(result, res, index + 1, n);
                res.deleteCharAt(index);
            }


        }
    }
    public static boolean ifRightvalid(String res){
        int cha = 0;
        for (int i = 0; i < res.length(); i++) {
            if(res.charAt(i)=='('){cha++;}
            if(res.charAt(i)==')'){cha--;}

        }
        return cha > 0;
    }
    public static boolean ifLeftvalid(String res,int n){
        int cha = 0;
        for (int i = 0; i < res.length(); i++) {
            if(res.charAt(i)=='('){cha++;}
        }
        return cha < n;
    }

}
