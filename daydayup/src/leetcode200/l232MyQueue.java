package leetcode200;

import java.util.Stack;

/*首先我要知道的是什么呢?Queue是队列,   Deque是双端队列
* Stack是栈
* 但是,然而，Stack 类并不推荐在新的代码中使用，因为它是遗留类，通常建议使用 Deque 接口的实现类，如 ArrayDeque，来代替。*/
public class l232MyQueue {
    /*实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false*/
    /*这是我自己想的,为什么不行呢?
    * 我知道了,不能这来来回倒腾,举例peek()一次之后,顺序又反了,所以还是要用分:出栈和入栈*/
    //Stack<Integer> stack1 = new Stack<>();
    //Stack<Integer> stack2 = new Stack<>();
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public l232MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if(stack2.isEmpty()){
            stack1.push(x);
        }else {
            stack2.push(x);
        }
    }

    public int pop() {
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int peek() {
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return stack1.peek();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
/*
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
