package leetcode;

import java.util.Stack;
//这个更简化了,懂了，不用放左括号，看到左括号就放准备匹配的右括号
public class l20_1 {
    public static void main(String[] args) {
        System.out.println(isValid("(()){}]"));
    }
    public static boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            System.out.println(stack);
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }
}
