package leetcode100;

import java.util.Stack;

public class l150 {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("*")){
                Integer p1 = stack.pop();
                Integer p2 = stack.pop();
                stack.push(p1*p2);
            }else if(tokens[i].equals("+")){
                Integer p1 = stack.pop();
                Integer p2 = stack.pop();
                stack.push(p1+p2);
            }else if(tokens[i].equals("-")){
                Integer p1 = stack.pop();
                Integer p2 = stack.pop();
                //stack.push(p1-p2);        /*!!!前一个数 减 后一个数啊!顺序别弄反啊!*/
                stack.push(p2-p1);
            }else if(tokens[i].equals("/")){
                Integer p1 = stack.pop();
                Integer p2 = stack.pop();
                //stack.push(p1/p2);
                stack.push(p2/p1);
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        //return stack.pop();
        return stack.pop();
    }
}
