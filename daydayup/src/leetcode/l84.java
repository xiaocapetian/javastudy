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
            while (!stack.isEmpty()&&newheights[i]<newheights[stack.peek()]){
                Integer big = stack.pop();
                //int small2 = newheights[stack.peek()];
                //int small1 = newheights[i];
                //int wide1 = i-big-1;
                //int wide2 = big-stack.peek()-1;
                int wide = i-stack.peek()-1;
                // System.out.println("wide:"+wide1+","+wide2);
                //System.out.println("small1:"+small1+",small2:"+small2+",big="+newheights[big]);
                area = Math.max(newheights[big]*wide,area);

//                if(small1<small2){
//                    int area1 = small1*(wide1+wide2-1);
//                    int area2 = small2*wide2;
//                    System.out.println("area:"+area1+","+area2);
//                    area = Math.max(Math.max(area1,area2),area);
//                }else {
//                    int area1 = small1*wide1;
//                    int area2 = small2*(wide1+wide2-1);
//                    System.out.println("area:"+area1+","+area2);
//                    area = Math.max(Math.max(area1,area2),area);
//                }
                //area = Math.max(newheights[big],area);
            }
            stack.push(i);
        }
        return area;

    }
}
