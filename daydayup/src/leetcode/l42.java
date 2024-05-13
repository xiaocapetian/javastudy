package leetcode;

import java.util.Stack;

/**这题千万别 动规dp
 * v0v1单调栈 , v2更简单啊(官方解答据说是叫动规,但是不用dp..
 */
public class l42 {
    public int trap(int[] height) {
        //根据老师讲的思路自己写的,单调栈拉出来,一层一层算
        Stack<Integer> stack = new Stack<>();
        int res= 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                Integer small = stack.pop();
                //int mid = height[small];
                if(!stack.isEmpty()){//左侧都没了,有雨也漏了..
                   int high = Math.min(height[i],height[stack.peek()])-height[small];
                   //如果有相等的其实不用多考虑直接放进去,在这一步high就是0,不影响了
                   int wide = i-stack.peek()-1;
                   res = res+high*wide;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
