package leetcode1000;

import java.util.Stack;

public class l1047 {
    //自己写的栈 Stack接口
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        //Deque<Character> deque = new ArrayDeque<>();
        //Deque<Character> deque2 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()||stack.peek()!=s.charAt(i)){
                stack.add(s.charAt(i));}
            else{
                //去除栈末这个,也不往里加
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
