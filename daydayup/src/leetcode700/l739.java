package leetcode700;

import java.util.Stack;

public class l739 {
    public int[] dailyTemperatures(int[] temperatures) {
//自己写的应该是对的,超时了
        //写的太弱智了
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length-1;i>=0;i--){
            Stack<Integer> stack = new Stack<>();
            for(int j = temperatures.length-1;j>i;j--){
                stack.push(temperatures[j]);
            }
            int count = 0;
            int temp = 0;
            while (!stack.isEmpty()){
                count++;
                temp =stack.pop();
                if(temp>temperatures[i]){break;}
            }
            if(temp<=temperatures[i]){res[i]=0;}
            else {res[i] =count;}

        }
        return res;
    }
}
