package leetcode200;

import java.util.Stack;

public class l227 {
    /**
     * 写的很慢,运行很慢 直接看v1,一样的思路人家就写的简单
     * @param s 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * @return 整数除法仅保留整数部分。
     */
    public int calculate(String s) {
        //Deque<String> deque = new ArrayDeque<>();
        Stack<String> stack = new Stack<>();
        char[] sarr = s.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            System.out.println(stack);
            if(sarr[i]>='0'&&sarr[i]<='9'){
                if(!stack.isEmpty()&&!stack.peek().equals("+")&&!stack.peek().equals("-")){
                    String newNum = stack.pop()+sarr[i];
                    stack.push(newNum);
                }else {
                    stack.push(sarr[i]+"");
                }
            }else if(sarr[i]==' '){
                continue;
            }else if(sarr[i]=='+'||sarr[i]=='-'){
                stack.push(sarr[i]+"");
            }else if(sarr[i]=='*'){
                int cheng1 = Integer.parseInt(stack.pop());
                int cheng2 = 0;
                i++;
                while (i<sarr.length&&((sarr[i]>='0'&&sarr[i]<='9')||sarr[i]==' ')){
                    if(sarr[i]!=' ')cheng2 = cheng2*10+Integer.parseInt(sarr[i]+"");
                    i++;
                }
                int ji = cheng1*cheng2;
                stack.push(ji+"");
                i--;
            }else if(sarr[i]=='/'){
                int beichu = Integer.parseInt(stack.pop());
                int chu = 0;
                i++;
                while (i<sarr.length&&((sarr[i]>='0'&&sarr[i]<='9')||sarr[i]==' ')){
                    if(sarr[i]!=' ')chu = chu*10+Integer.parseInt(sarr[i]+"");
                    i++;
                }
                int shang = beichu/chu;
                stack.push(shang+"");
                i--;
            }
        }
        int res=0;
        while (!stack.isEmpty()){
            int shu = Integer.parseInt(stack.pop());
            if(!stack.isEmpty()){
                if(stack.pop().equals("+")){
                    res = res+shu;
                }else {
                    res = res-shu;
                }
            }else {
                res = res+shu;
            }

        }
        return res;

    }
}
