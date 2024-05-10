package leetcode;

import java.util.Stack;

public class l20 {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
    public static boolean isValid(String s) {
        if(s.length()==0){return true;}
        Stack<Character> stack = new Stack<>();
        stack.push('？');
        for (char c:s.toCharArray()) {
            //if
            if(c=='('||c=='['||c=='{'){stack.push(c);}
            if(c==')'){if(stack.peek()=='('){stack.pop();}else{return false;}
            }
            if(c==']'){if(stack.peek()=='['){stack.pop();}else{return false;}}
            if(c=='}'){if(stack.peek()=='{'){stack.pop();}else{return false;}}

            System.out.println(stack);
        }
        stack.pop();
        return stack.empty();


    }
}
