package leetcode200;

import java.util.LinkedList;
import java.util.Queue;

public class l225MyStack {//这是我自己写的啦,两个队列可以模拟栈,一个队列也可以噢,查一下队列的size,弹出size-1个然后再放进去就行
    Queue<Integer> queue1;
    Queue<Integer> queue2;
/*
* 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

实现 MyStack 类：

void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。*/
    public l225MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if(queue2.isEmpty()){
            queue1.add(x);
        }else {
            queue2.add(x);
        }
    }

    public int pop() {
        if(queue1.isEmpty()){
            while (queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }else {
            while (queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
    }

    public int top() {
        if(queue1.isEmpty()){
            while (queue2.size()>1){
                queue1.add(queue2.poll());
            }
            Integer i = queue2.poll();
            queue1.add(i);
            return i;
        }else {
            while (queue1.size()>1){
                queue2.add(queue1.poll());
            }
            Integer i = queue1.poll();
            queue2.add(i);
            return i;
        }
    }

    public boolean empty() {
return queue1.isEmpty()&&queue2.isEmpty();
    }
}
