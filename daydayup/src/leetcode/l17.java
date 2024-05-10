package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//抄的，回溯
//回溯通常用于搜索所有可能的解决方案，尤其是在组合或排列等问题中。
//回溯算法是对树形或者图形结构执行一次深度优先遍历，类似枚举的搜索尝试过程
//好难啊QAQ
public class l17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length()==0){
            return combinations;
        }
        Map<Character,String> phoneMap = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        //backtrack(combinations,phoneMap,digits,0,new StringBuffer());
        backtrack(combinations,phoneMap,digits,0,new StringBuilder());
        return combinations;
    }
    //backtrack 回溯
    public static void backtrack(List<String> combinations,Map<Character,String> phoneMap,String digits,int index, StringBuilder combination){
        System.out.println("index = " +index +" combination = "+combination.toString()+ " combinations = "+combinations);
        if(index == digits.length()){
            combinations.add(combination.toString());//最开始不往里放，combination长度够了才往里放
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);//当然，要把最后一位去掉（a），换下一种可能（b,c）
            }

        }

    }


}
