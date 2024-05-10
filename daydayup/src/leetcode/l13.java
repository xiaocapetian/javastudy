package leetcode;

import java.util.HashMap;
import java.util.Map;

public class l13 {
    Map<Character,Integer> symbolValues = new HashMap<>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};//在初始化时就向哈希表赋值就要使用双层大括号里put，也在之后可以用put往里加。
    public int romanToInt(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = symbolValues.get(s.charAt(i));
            if(i == s.length()-1||value >= symbolValues.get(s.charAt(i+1))){
                count = count + value;
            }else{
                count = count - value;
            }
            //System.out.println("count = "+ count);
        }

        return count;

    }
}
