package leetcode;

import java.util.ArrayList;
import java.util.List;
//自己跟着回溯仿写的，在往list里加时才判断合法吗，非常慢
public class l22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuilder(),0,n);
        return result ;
    }
    public static void backtrack(List<String> result,StringBuilder res, int index,int n){
        //System.out.println("index= "+index+"res= "+res.toString()+"result= "+result);
        if(index==n*2){
            if(ifvalid(res.toString())){result.add(res.toString());}
            //result.add(res.toString());
        }else {
            String[] strs= {"(",")"};
            for (int i = 0; i < strs.length; i++) {
                res.append(strs[i]);
                backtrack(result,res,index+1,n);
                res.deleteCharAt(index);
            }


        }
    }
    public static boolean ifvalid(String res){
        int cha = 0;
        for (int i = 0; i < res.length(); i++) {
            if(res.charAt(i)=='('){cha++;}
            if(res.charAt(i)==')'){cha--;}
            if(cha<0){return false;}
        }
        return cha == 0;
    }

}
