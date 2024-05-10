package leetcode700;

import java.util.Stack;

public class l739v1 {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        //stack.push(0);
        for (int i = 0; i < temperatures.length; i++) {
            //自己第一遍就写出了精简版
            //为什么是while,因为只要还没空,栈顶的又大就一直弹出
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                Integer small = stack.pop();
                res[small] = i-small;
            }
            //直到比栈顶的小了或者栈空了,放进去
            stack.push(i);
        }
        return res;
    }
}
