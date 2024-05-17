package leetcode;

import java.util.Stack;

public class l84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        //首尾加0
        int[] newheights = new int[heights.length+2];
        newheights[0] = 0;
        newheights[heights.length+1] = 0;
        for(int i =1;i<heights.length+1;i++){
            newheights[i] = heights[i-1];
        }

        int area = 0;
        for (int i = 0; i < newheights.length; i++) {
            //本题的想法是求左边第一个比它小的,右边第一个比它小的
            //而且是遇到比它小的就不要了!
            //千万不要想着左一个右一个!!

            //参考l42接雨水的想法,很多相似的
            //我的单调栈是一个栈顶最大,越深越小的
            //我手上的newheights[i]比栈顶的要小,那就不行了,得取出来
            while (!stack.isEmpty()&&newheights[i]<newheights[stack.peek()]){
                Integer big = stack.pop();

                int wide = i-stack.peek()-1;//得一个宽度
                //高度是newheights[big]
                //System.out.println("wide:"+wide1+","+wide2);
                //System.out.println("small1:"+small1+",small2:"+small2+",big="+newheights[big]);
                area = Math.max(newheights[big]*wide,area);

            }
            stack.push(i);
        }
        return area;

    }
}
