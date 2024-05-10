package leetcode;

import java.util.ArrayList;
import java.util.List;
/*这是我根据套路自己写出来的,我能行!!!!!*/
public class l17_1 {
    public static void main(String[] args) {
        System.out.println("res = "+letterCombinations("23"));
    }

    static String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};//用这个,甚至不用hashmap来存对于关系了
    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits.length()==0){return res;}//记住这里空返回空,要写if(digits.length()==0),若写digits==""是不行的
        backtrack(digits,res, new StringBuilder(),0);
        return res;

    }
    static void backtrack(String digits,List<String> res,StringBuilder path,int item){
        System.out.println(path);
        if(path.length()==digits.length()){
            res.add(path.toString());
            return;
        }

        for (int i = 0;i<str[digits.charAt(item)-'0'].length();i++){
/*注意这里的区别了 ,为什么是int i = 0?画一个树!item只是控制电话号码"23"的第多少位,对于每一层来说,都是要全的
* */
            path.append(str[digits.charAt(item)-'0'].charAt(i));
            backtrack(digits,res,path,item+1);
            //这里要放item+1,这里的item不是之前的startitem,这里的item控制的是在输入列"23"的第多少位
            path.deleteCharAt(path.length()-1);
        }
    }
}
