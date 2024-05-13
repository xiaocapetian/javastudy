package leetcode;

import java.util.Stack;

public class l42v1 {
    //二刷自己写一遍咯
    public int trap(int[] height) {

        //单调栈   横着求的
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        //栈里只能放递减的数<==这些数是等着接雨水的,是碗的半边啊!
        for (int i = 0; i < height.length; i++) {

            //如果出现我现在手上的height[i]比栈首的大!这会导致什么问题啊?可以接到雨水了!
            // (栈里是越往深处越高,我现在手上这个也高,那么不就高低高了?不就可接雨水了?
            // =====能接到多少雨水?
            while (!stack.isEmpty()&&height[stack.peek()]<height[i]){

                int di = height[stack.pop()];
                //如果后面还有深的,就继续. 如果后面没有就算了,就把这个小的di给扔掉(左侧都没了,有雨也漏了..)
                if(!stack.isEmpty()){            //如果还有,因为是单调栈--肯定是比这个di大的
                    int high = Math.min(height[stack.peek()],height[i])-di;
                    int chang = i-stack.peek()-1;                             /*[易错]:这里有个-1别漏了*/
                    System.out.println("chang = "+chang+"high = "+high  );
                    res = res+high*chang;
                }

            }
            //👇实际上这里肯定满足这个了,所以不用if了  <==这地方其实都要推进栈里,无论走不走上面的while ()~
            //if(stack.isEmpty()||height[stack.peek()]>=height[i]){
            stack.push(i);      //[重难点]:把谁推进去?把下标推进去!不是把值推进去-----有什么好处?算距离的时候有下下标,比数值的时候可以进数组
            //}
        }
        return res;
    }
}
