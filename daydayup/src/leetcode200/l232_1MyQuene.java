package leetcode200;

import java.util.Stack;

public class l232_1MyQuene {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
/*进栈之后就准备出了,对吧,如果出栈是空的,就把进栈里的东西全转到出栈里,出一个,
* 如果出栈的东西不是空的,那就直接从出栈里出*/
    /** Initialize your data structure here. */
    public l232_1MyQuene() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }
    /**int pop() 从队列的开头移除并返回元素*/
    public int pop() {
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }
    public int peek() {
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
    public boolean empty() {
        return stackIn.isEmpty()&&stackOut.isEmpty();
    }

}
