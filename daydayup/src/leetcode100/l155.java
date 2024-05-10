package leetcode100;

import java.util.Stack;

public class l155 {
//两个栈,一个栈正常存值,一个栈存最小值,有意思吧
}
class MinStack{

    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty()){minstack.push(val);}
        else {
//            if(minstack.peek()<val){
//                minstack.push(minstack.peek());
//            }else {
//                minstack.push(val);
//            }
            /*👇比👆要快1ms*/
            minstack.push(Math.min(minstack.peek(), val));
        }

    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minstack.peek();
    }
}