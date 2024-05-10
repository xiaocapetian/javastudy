package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class l20_2 {
    //学了之后自己写! 简洁!我可以!
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){deque.push(')');}
            if(s.charAt(i)=='['){deque.push(']');}
            if(s.charAt(i)=='{'){deque.push('}');}
            if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                if(deque.isEmpty()||deque.pop()!=s.charAt(i)){
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
