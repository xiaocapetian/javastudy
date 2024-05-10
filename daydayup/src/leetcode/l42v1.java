package leetcode;

import java.util.Stack;

public class l42v1 {
    //二刷自己写一遍咯
    public int trap(int[] height) {

        //单调栈   横着求的
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        //栈里只能放递减的数
        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty()&&height[stack.peek()]<height[i]){
                System.out.println();
                int di = height[stack.pop()];
                if(!stack.isEmpty()){            //如果还有,因为是单调栈--肯定是比这个di大的
                    int high = Math.min(height[stack.peek()],height[i])-di;
                    int chang = i-stack.peek()-1;                             /*[易错]:这里有个-1别漏了*/
                    System.out.println("chang = "+chang+"high = "+high  );
                    res = res+high*chang;
                }

            }
            //👇实际上这里肯定满足这个了,所以不用if了
            //if(stack.isEmpty()||height[stack.peek()]>=height[i]){
            stack.push(i);      //[重难点]:把谁推进去?把下标推进去!不是把值推进去-----有什么好处?算距离的时候有下下标,比数值的时候可以进数组
            //}
        }
        return res;
    }
}
